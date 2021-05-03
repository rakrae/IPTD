package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.NewYearsResolution;
import model.Target;

public class NewYearsResolutionController extends CommonProprietiesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label titleIPTDList;

	@FXML
	private Button closeProgram;

	@FXML
	private Button back;

	@FXML
	private Button addNewTarget;

	@FXML
	private TableView<Target> nyrListView;

	@FXML
	private TableColumn<Target, String> targetColumn;

	@FXML
	private TableColumn<Target, String> deleteColumn;

	@FXML
	private TextField targetTextField;

	@FXML
	void handleAddNewTargetPressed(ActionEvent event) {

		// adding a target
		String target_Text = targetTextField.getText();

		if (!target_Text.isEmpty()) {

			Target target = new Target();
			System.out.println(target);

			targetList.add(target);
			targetRepository.add(target);
			
			System.out.println(targetList);
		}

	}

	@FXML
	void handleBackPressed(ActionEvent event) {

		Stage stageLogin = (Stage) back.getScene().getWindow();
		stageLogin.close();

		openScene(PERSISTANCE_NAME_YEARLIST);
		
		stageLogin.hide();
	}

	@FXML
	void handleClosePressed(ActionEvent event) {

		System.exit(0);

	}

	@FXML
	void initialize() {
		assert titleIPTDList != null
				: "fx:id=\"titleIPTDList\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert closeProgram != null : "fx:id=\"closeProgram\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert addNewTarget != null : "fx:id=\"addNewTarget\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert nyrListView != null : "fx:id=\"iptdListView\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert targetColumn != null : "fx:id=\"targetColumn\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert deleteColumn != null : "fx:id=\"deleteColumn\" was not injected: check your FXML file 'IPTD_List.fxml'.";
		assert targetTextField != null
				: "fx:id=\"targetTextField\" was not injected: check your FXML file 'IPTD_List.fxml'.";

		// TODO: add dummies + set the delete button

		// adding a target
		addNewTarget.disabledProperty().and(targetTextField.textProperty().isEmpty());

		// targets in the NYR
		nyrListView.setItems(targetList);

		// target for each column
		targetColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTargetName()));

		// for changes
		nyrListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Target>() {

			@Override
			public void changed(ObservableValue<? extends Target> observable, Target oldValue, Target newValue) {

				System.out.println("Table selection called: " + newValue);
				selectedTarget.set(newValue);

			}
		});

		
		// Setting the button to go into the Target's scene
		var enterNYR = new Callback<TableColumn<Target, String>, TableCell<Target, String>>() {

			@Override
			public TableCell<Target, String> call(TableColumn<Target, String> param) {

				TableCell<Target, String> cell = new TableCell<Target, String>() {

					String name = targetTextField.getText();

					Button tg = new Button(name);

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, !empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							tg.setOnAction(e -> {
								Target target = getTableView().getItems().get(getIndex());
								targetList.add(getIndex(), target);

								// opening the NewYearsResolution scene
								Stage stageLists = (Stage) back.getScene().getWindow();
								stageLists.close();

								openScene(PERSISTANCE_NAME_TARGET);
								
								stageLists.hide();
							});
							setGraphic(tg);
							setText(null);
						}
					}

				};
				return cell;
			}

		};
		targetColumn.setCellFactory(enterNYR);
		
		

		// delete button
		var deleteCallBack = new Callback<TableColumn<Target, String>, TableCell<Target, String>>() {

			@Override
			public TableCell<Target, String> call(TableColumn<Target, String> param) {

				TableCell<Target, String> cell = new TableCell<Target, String>() {

					Button deleteButton = new Button("Delete");

					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);

						} else {

							deleteButton.setOnAction(e -> {
								Target target = getTableView().getItems().get(getIndex());
								targetList.remove(target);

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
