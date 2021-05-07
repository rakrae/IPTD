package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.NewYearsResolution;
import model.YearList;
import repository.NewYearsResolutionRepositoryJPA;

public class YearList_Controller extends CommonProprietiesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button closeProgram;

	@FXML
	private Button backButton;

	@FXML
	private Button createNewList;

	@FXML
	private TableView<NewYearsResolution> yearListView;

	@FXML
	private TableColumn<NewYearsResolution, String> yearListColumn;

	@FXML
	private TableColumn<NewYearsResolution, String> deleteColumn;

	@FXML
	private TextField nyrTextField;

	@FXML
	void handleBackPressed(ActionEvent event) {

		Stage stageLists = (Stage) backButton.getScene().getWindow();
		stageLists.close();

		openScene(PERSISTANCE_NAME_ACCOUNT);
		
		stageLists.close();
	}

	@FXML
	void handleClosePressed(ActionEvent event) {

		System.exit(0);

	}

	@FXML
	void handleCreateNewListPressed(ActionEvent event) {

		// Adding a NYR list
		String nyrName = nyrTextField.getText();

		// checking if the name is not empty
		if (!nyrName.isEmpty()) {

			NewYearsResolution newyearsresolution = new NewYearsResolution(0l,nyrName, null);
			System.out.println(newyearsresolution);

			nyrList.add(newyearsresolution);
			nyrRepository.add(newyearsresolution);
			
			
			System.out.println(nyrList);
		}

	}

	@FXML
	void initialize() {

		assert closeProgram != null
				: "fx:id=\"closeProgram\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert createNewList != null
				: "fx:id=\"createNewList\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert yearListView != null
				: "fx:id=\"iptd_listsView\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert yearListColumn != null
				: "fx:id=\"iptdListsColumn\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert deleteColumn != null
				: "fx:id=\"deleteColumn\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
		assert nyrTextField != null
				: "fx:id=\"iptdTextField\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";

		
		// Should open the NewYearsResolution

		// adding a NYR List
		createNewList.disableProperty().bind(nyrTextField.textProperty().isEmpty()); 
		
		// NewYearsResolutions in the YearList
		yearListView.setItems(nyrList);

		// Resolutions for each column
		yearListColumn
				.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNewYearsResolutionName()));

		// For changes (just in any case)
		yearListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<NewYearsResolution>() {

			@Override
			public void changed(ObservableValue<? extends NewYearsResolution> observable, NewYearsResolution oldValue,
					NewYearsResolution newValue) {

				System.out.println("Table selection changed called: " + newValue);
				selectedNYR_List.set(newValue);
				
				if(newValue != null) {
					Stage stageLists = (Stage) backButton.getScene().getWindow();
					stageLists.close();

					openScene(PERSISTANCE_NAME_NEWYEARS_RESOLUTION);
					
					stageLists.hide();
				} else {
					
				}
				
			}

		});

		
		// Delete Button for deteleColumn
		var deleteCallBack = new Callback<TableColumn<NewYearsResolution, String>, TableCell<NewYearsResolution, String>>() {

			@Override
			public TableCell<NewYearsResolution, String> call(TableColumn<NewYearsResolution, String> param) {

				TableCell<NewYearsResolution, String> cell = new TableCell<NewYearsResolution, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {

						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							deleteButton.setOnAction(e -> {
								NewYearsResolution nyr = getTableView().getItems().get(getIndex());
								nyrList.remove(nyr);
								nyrRepository.delete(nyr);
							});
							setGraphic(deleteButton);
							setText(null);
						}
					}
				};
				return cell;
			}
		};
		deleteColumn.setCellFactory(deleteCallBack);

	}
}
