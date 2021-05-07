package controller;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import model.Account;
import model.YearList;

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
    void handleDeleteAccountPressed(ActionEvent event){
    	
    	Stage loginScene = (Stage) deleteButton.getScene().getWindow();
    	loginScene.close();
    	
    	Account account = selectedAccount.getValue();
    	
    	// Delete account
    	try {
        	accountRepository.delete(account);
        	accountList.remove(account);
        	openScene(PERSISTANCE_NAME_LOGIN);
        } catch(NullPointerException e)
            {
        	e.printStackTrace();
            System.out.print("Could not delete account!");
            accountList.remove(account);
            openScene(PERSISTANCE_NAME_LOGIN);
        }
    	loginScene.hide();
    	
    }

    @FXML
    void handleEditAccountPressed(ActionEvent event) {

    	Stage newStage = (Stage) editAccountButton.getScene().getWindow();
		newStage.close();

		openSceneOnHidden(PERSISTANCE_NAME_EDIT_ACCOUNT, newStage);
		
    	newStage.hide();
    	
    }

    @FXML
    void handleIPTDListsPressed(ActionEvent event) {
    	
    	Stage newStage = (Stage) editAccountButton.getScene().getWindow();
		newStage.close();
	
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
        
        // Setting the names for the account profile
        Account currentAccount = selectedAccount.get();
        titleFirstNameText.setText(currentAccount.getFirstName());
        titleAccountText.setText(currentAccount.getAccount());
        accountText.setText(currentAccount.getAccount());
        firstNameText.setText(currentAccount.getFirstName());
        lastNameText.setText(currentAccount.getLastName());
        
        accountList.addListener(new ListChangeListener<Account>() {

			@Override
			public void onChanged(Change<? extends Account> c) {
				
				while(c.next()) {
					
					if(c.wasRemoved()) {
						for(Account ac : c.getRemoved()) {
							
							ListIterator<YearList> itr = yearList.listIterator();
							
							while(itr.hasNext()) {
								
								YearList y = itr.next();
								if(y.getLists().equals(ac)) {
									itr.remove();
								}
							}
						}
					}
					
				}
			}
        	
        });
        
        
        
        
        
    }
}
