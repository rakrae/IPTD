package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Account;

public class AccountController extends CommonProprietiesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label titleFirstNameText;

    @FXML
    private Label titleAccountText;

    @FXML
    private Label accountText;

    @FXML
    private Label firstNameText;

    @FXML
    private Label lastNameText;

    @FXML
    private Button iptdListsButton;

    @FXML
    private Button editAccountButton;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button closeButton;

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    void handleBackPressed(ActionEvent event) {

    	Stage stageBack = (Stage) backButton.getScene().getWindow();
		stageBack.close();
		
		openScene(PERSISTANCE_NAME_LOGIN);
		
		stageBack.hide();
    }

	@FXML
    void handleClosePressed(ActionEvent event) {

    	System.exit(0);
    	
    }

    @FXML
    void handleDeleteAccountPressed(ActionEvent event) {
    	
    	Account account = selectedAccount.get();
    	
    	accountList.remove(account);
    	
    	accountRepository.delete(account);
    	
    }

    @FXML
    void handleEditAccountPressed(ActionEvent event) {

    	Stage newStage = (Stage) editAccountButton.getScene().getWindow();
		newStage.close();
    	
//		openScene(PERSISTANCE_NAME_EDIT_ACCOUNT);
    	
		openSceneOnHidden(PERSISTANCE_NAME_EDIT_ACCOUNT, newStage);
		
    	newStage.hide();
    	
    }

    @FXML
    void handleIPTDListsPressed(ActionEvent event) {
    	
    	Stage newStage = (Stage) editAccountButton.getScene().getWindow();
		newStage.close();
    	
//		openScene(PERSISTANCE_NAME_YEARLIST);
		
		openSceneOnHidden(PERSISTANCE_NAME_YEARLIST, newStage);
    	
		newStage.hide();
    }

    @FXML
    void initialize() {
        assert titleFirstNameText != null : "fx:id=\"titleFirstNameTextField\" was not injected: check your FXML file 'Account.fxml'.";
        assert titleAccountText != null : "fx:id=\"titleAccountTextfield\" was not injected: check your FXML file 'Account.fxml'.";
        assert accountText != null : "fx:id=\"accountTextfield\" was not injected: check your FXML file 'Account.fxml'.";
        assert firstNameText != null : "fx:id=\"firstNameTextfield\" was not injected: check your FXML file 'Account.fxml'.";
        assert lastNameText != null : "fx:id=\"lastNameTextfield\" was not injected: check your FXML file 'Account.fxml'.";
        assert iptdListsButton != null : "fx:id=\"iptdListsButton\" was not injected: check your FXML file 'Account.fxml'.";
        assert editAccountButton != null : "fx:id=\"editAccountButton\" was not injected: check your FXML file 'Account.fxml'.";
        assert progressIndicator != null : "fx:id=\"progressIndicator\" was not injected: check your FXML file 'Account.fxml'.";
        assert progressBar != null : "fx:id=\"progressBar\" was not injected: check your FXML file 'Account.fxml'.";
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'Account.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'Account.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'Account.fxml'.";

    }
}
