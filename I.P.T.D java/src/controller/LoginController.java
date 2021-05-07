package controller;

import java.util.List;
import java.util.Optional;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;

public class LoginController extends CommonProprietiesController {


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeProgramm;

    @FXML
    private TextField accountTextField;

    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private Button login;

    @FXML
    private Button newAccount;

    @FXML
    void handleClosePressed(ActionEvent event) {
    	System.exit(0);
    }

    
    @FXML
    void handleLoginPressed(ActionEvent event) {

    	Stage primaryStage = (Stage) accountTextField.getScene().getWindow();
    	primaryStage.close();
    	
    	List<Account> accounts = accountRepository.readAll();
    	
    	// Checking if the account list is empty or not!
//    	if(accounts.isEmpty()) {
//    		String first = "Account list is empty!";
//			String second = "Create an account first";
//			
//			ModalDialog dialog = new ModalDialog(first, second);
//    		Optional<ButtonType> result = dialog.showAndWait();
//			if(result.isPresent()) {
//    			if(result.get() == ButtonType.OK) {
//    				openScene(PERSISTANCE_NAME_LOGIN);
//    				System.out.println("Dialog ok");
//	
//    						} 
//						}
//    	}
    	
    	// Triggers only if the fields are empty
    	if(accountTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {

    		String first = "Fill in the fields!";
			String second = "Try again";
			
			ModalDialog dialog = new ModalDialog(first, second);
    		Optional<ButtonType> result = dialog.showAndWait();
			if(result.isPresent()) {
    			if(result.get() == ButtonType.OK) {
    				openScene(PERSISTANCE_NAME_LOGIN);
    				System.out.println("Dialog ok");
    						}
						}
			
	    	} else { 

	    	int i = 0;
	    		
	        for(Account a : accounts) {
    	
	        	checkAccount(a);
	        	
	        	// Mit boolean hätte es nicht funktioniert da ich so oft einen ModalDialog bekommen hätte wie viele accounts gibt es
	        		if(!a.getAccount().equals(accountTextField.getText()) && !a.getPassword().equals(passwordTextField.getText())) {
    						
						++i;
						if(i == accounts.size()) {
        						String first = "Incorect account and password!";
        	    				String second = "Try again";
        	    				
        	    				ModalDialog dialog = new ModalDialog(first, second);
        	    	    		Optional<ButtonType> result = dialog.showAndWait();
        	    				if(result.isPresent()) {
        	    	    			if(result.get() == ButtonType.OK) {
        	    	    				openScene(PERSISTANCE_NAME_LOGIN);
        	    	    				System.out.println("Dialog ok");
        				
        	    	    						} 
        	    							}
        								}
									}
    							}
    						}

    }

    @FXML
    void handleNewAccountPressed(ActionEvent event) {
    	
    	Stage primaryStage = (Stage) passwordTextField.getScene().getWindow();
    	primaryStage.close();
    	
    	openScene(PERSISTANCE_NAME_NEW_ACCOUNT);
    	
    	primaryStage.hide();
    }

    @FXML
    void initialize() {
        assert closeProgramm != null : "fx:id=\"closeProgramm\" was not injected: check your FXML file 'Login.fxml'.";
        assert accountTextField != null : "fx:id=\"accountTextField\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert newAccount != null : "fx:id=\"newAccount\" was not injected: check your FXML file 'Login.fxml'.";

    }
    
    // Login method 
    public void checkAccount(Account account) {

    	if(account.getAccount().equals(accountTextField.getText()) && account.getPassword().equals(passwordTextField.getText())) {

    		// It sets the account in the account controller
    		selectedAccount.setValue(account);
    		
    		// Opens Account scene
    		openScene(PERSISTANCE_NAME_ACCOUNT);

//    		selectedAccount.unbind();
    				} 
    			}
    		
    }
    
    
    
