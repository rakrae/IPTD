package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.YearList;

public class YearList_Controller {

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
    private TableView<YearList> iptd_listsView;

    @FXML
    private TableColumn<YearList, String> iptdListsColumn;

    @FXML
    private TableColumn<YearList, String> deleteColumn;
    
    @FXML
    private TextField iptdTextField;

    @FXML
    void handleBackPressed(ActionEvent event) {
    	
    	Stage stageLists = (Stage) backButton.getScene().getWindow();
    	stageLists.close();
    	
    	try { // Hier wird die zweite Fenster geöffnet

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Account.fxml"));

			Parent root = (Parent) loader.load();


			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			
//			stage.setOnHidden(e -> newStage.show()); // in plus
			
			stage.show();
			
			stageLists.hide();
			
		 // dazu
			
		} catch (Exception e) {
			System.err.println("Can not load Account");
			e.printStackTrace();
		}
    	

    }

    @FXML
    void handleClosePressed(ActionEvent event) {
    	
    	System.exit(0);

    }

    @FXML
    void handleCreateNewListPressed(ActionEvent event) {
    	
    	

    }

    @FXML
    void initialize() {
        assert closeProgram != null : "fx:id=\"closeProgram\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert createNewList != null : "fx:id=\"createNewList\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert iptd_listsView != null : "fx:id=\"iptd_listsView\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert iptdListsColumn != null : "fx:id=\"iptdListsColumn\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert deleteColumn != null : "fx:id=\"deleteColumn\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";
        assert iptdTextField != null : "fx:id=\"iptdTextField\" was not injected: check your FXML file 'IPTD_Lists.fxml'.";

        
        
    }
}
