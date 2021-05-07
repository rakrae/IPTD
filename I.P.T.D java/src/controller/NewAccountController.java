package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;
import model.YearList;

public class NewAccountController extends CommonProprietiesController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField accountTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField reenterPasswordTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField genderTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button createAccount;

    @FXML
    private Button cancelCreate;

    @FXML
    void handleCancelPressed(ActionEvent event) {

    	Stage stageLogin = (Stage) cancelCreate.getScene().getWindow();
		stageLogin.close();
    	
		openScene(PERSISTANCE_NAME_LOGIN);
		
		System.out.println(accountList);
		stageLogin.close();
    }

    // Creating a new account
    @FXML
    void handleCreateAccountPressed(ActionEvent event) {

    	String account = accountTextField.getText();
    	String password = passwordTextField.getText();
    	String rePassword = reenterPasswordTextField.getText();
    	String firstName = firstNameTextField.getText();
    	String lastName = lastNameTextField.getText();
    	String gender = genderTextField.getText();
    	String ageString = ageTextField.getText();
    	int age = Integer.parseInt(ageString);
    	
    	if(!account.isEmpty() && !password.isEmpty() && password.equals(rePassword) && !firstName.isEmpty() && !lastName.isEmpty() && !gender.isEmpty() && age != 0 && age > 0){
    		
    		/*
    		 * 
    		 */
    		
    		
    		long i = selectedYearList.get().getId();
    		
    		YearList yl = new YearList(i, null);
    		yearList.add(yl);
    		yearListRepository.add(yl);
    		
    		Account newAccount = new Account(0l,account, password, firstName, lastName, gender, age,yl);
    		
    		System.out.println(accountList);
    		// Adding the new account 
    		accountList.add(newAccount);
    		accountRepository.add(newAccount);
    		
   
    		System.out.println(accountList);
    			
    			String first = "Account Succesfully created!";
    			String second = "Press ok and login";
    			
        		ModalDialog dialog = new ModalDialog(first, second);
        		Optional<ButtonType> result = dialog.showAndWait();
        		if(result.isPresent()) {
        			if(result.get() == ButtonType.OK) {
        				System.out.println("Dialog ok");
        				
        				Stage stageLogin = (Stage) cancelCreate.getScene().getWindow();
        				stageLogin.close();
        				
        				openScene(PERSISTANCE_NAME_LOGIN);
        				
        				stageLogin.close();
        			} else {
        				System.out.println("Dialog cancel");
        			}
        		}
        		
    	} else {
    		
    	}

    }
    
    

    @FXML
    void initialize() {
        assert accountTextField != null : "fx:id=\"accountTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert reenterPasswordTextField != null : "fx:id=\"reenterPasswordTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert firstNameTextField != null : "fx:id=\"firstNameTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert lastNameTextField != null : "fx:id=\"lastNameTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert genderTextField != null : "fx:id=\"genderTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert ageTextField != null : "fx:id=\"ageTextField\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert createAccount != null : "fx:id=\"createAccount\" was not injected: check your FXML file 'NewAccount.fxml'.";
        assert cancelCreate != null : "fx:id=\"cancelCreate\" was not injected: check your FXML file 'NewAccount.fxml'.";

    }
}
