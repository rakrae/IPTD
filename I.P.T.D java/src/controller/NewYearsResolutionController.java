package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.NewYearsResolution;

public class NewYearsResolutionController {

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
    private TableView<NewYearsResolution> iptdListView;

    @FXML
    private TableColumn<NewYearsResolution, String> targetColumn;

    @FXML
    private TableColumn<NewYearsResolution, String> deleteColumn;

    @FXML
    private TextField targetTextField;

    @FXML
    void handleAddNewTargetPressed(ActionEvent event) {

    }

    @FXML
    void handleBackPressed(ActionEvent event) {

    	Platform.exit();
    	
    }

    @FXML
    void handleClosePressed(ActionEvent event) {

    	System.exit(0);
    	
    }

    @FXML
    void initialize() {
        assert titleIPTDList != null : "fx:id=\"titleIPTDList\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert closeProgram != null : "fx:id=\"closeProgram\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert addNewTarget != null : "fx:id=\"addNewTarget\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert iptdListView != null : "fx:id=\"iptdListView\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert targetColumn != null : "fx:id=\"targetColumn\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert deleteColumn != null : "fx:id=\"deleteColumn\" was not injected: check your FXML file 'IPTD_List.fxml'.";
        assert targetTextField != null : "fx:id=\"targetTextField\" was not injected: check your FXML file 'IPTD_List.fxml'.";

    }
}
