package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Account;

public class EditAccountController extends CommonProprietiesController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label accountsNameTitle;

    @FXML
    private PasswordField oldPasswordTextField;

    @FXML
    private PasswordField newPasswordTextField;

    @FXML
    private PasswordField reenterPasswordTextField;

    @FXML
    private TextField editFirstNameTextfield;

    @FXML
    private TextField editLastNameTextField;

    @FXML
    private TextField editGenderTextField;

    @FXML
    private TextField editAgeTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button saveChanges;
    
    private String text;
    
    public String getText() {
    	return text;
    }
    

    @FXML
    void handleBackPressed(ActionEvent event) {

    	Stage stageEdit = (Stage) backButton.getScene().getWindow();
		stageEdit.close();
		
		openScene(PERSISTANCE_NAME_ACCOUNT);
		
    	stageEdit.hide();
    }

    @FXML
    void handleSaveChangedPressed(ActionEvent event) {
    	
    	if(oldPasswordTextField.getText().isEmpty() || newPasswordTextField.getText().isEmpty() 
    			|| reenterPasswordTextField.getText().isEmpty() || editFirstNameTextfield.getText().isEmpty()
    			|| editLastNameTextField.getText().isEmpty() || editGenderTextField.getText().isEmpty()
    			|| editAgeTextField.getText().isEmpty()) {
    		
    		String c = "Please fill all the fields!";
    		String f = "Press ok";
    		
    		ModalDialog dialog_1D = new ModalDialog(c, f);
    		Optional<ButtonType> result_1R = dialog_1D.showAndWait();
    		if(result_1R.isPresent()) {
    			if(result_1R.get() == ButtonType.OK) {
    				
    				Stage stageEdit = (Stage) saveChanges.getScene().getWindow();
    				stageEdit.close();
    				
    				openScene(PERSISTANCE_NAME_ACCOUNT);
    				
    				System.out.println("Dialog ok");
    					}
    				}
    	} else {
    		
    	updateAccount();
    	
    	}
    	
    }

	@FXML
    void initialize() {
        assert accountsNameTitle != null : "fx:id=\"accountsNameTitle\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert oldPasswordTextField != null : "fx:id=\"oldPasswordTextfield\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert newPasswordTextField != null : "fx:id=\"newPasswordTextfield\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert reenterPasswordTextField != null : "fx:id=\"reenterPasswordTextfield\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert editFirstNameTextfield != null : "fx:id=\"editFirstNameTextfield\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert editLastNameTextField != null : "fx:id=\"editLastNameTextField\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert editGenderTextField != null : "fx:id=\"editGenderTextField\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert editAgeTextField != null : "fx:id=\"editAgeTextField\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'EditAccount.fxml'.";
        assert saveChanges != null : "fx:id=\"saveChanges\" was not injected: check your FXML file 'EditAccount.fxml'.";
        
        Account account = selectedAccount.get();
        accountsNameTitle.setText(account.getAccount());
        
        selectedAccount.addListener( new ChangeListener<Account>() {

			@Override
			public void changed(ObservableValue<? extends Account> observable, Account oldValue, Account newValue) {
				
				System.out.println("Table selection changed called: " + newValue);
				
				if(newValue != null) {
				reenterPasswordTextField.setText(newValue.getPassword());
				editFirstNameTextfield.setText(newValue.getFirstName());
				editLastNameTextField.setText(newValue.getLastName());
				editGenderTextField.setText(newValue.getGender());
				
				int a = newValue.getAge();
				@SuppressWarnings("deprecation")
				Integer x = new Integer(a);
				editAgeTextField.setText(x.toString().getClass().getName());
				
				}
			}
        });
        
        
    }
	
	public void updateAccount() {
		
		Account newAccount = selectedAccount.get();
    	
    	accountList.remove(newAccount);
    	accountRepository.delete(newAccount);
    	
//    	int index = accountList.indexOf(newAccount); 
    	
    	String ageS = editAgeTextField.getText();
    	
    	int age = Integer.parseInt(ageS);
    	
    	if(newAccount.getPassword().equals(oldPasswordTextField.getText()) && newPasswordTextField.getText().equals(reenterPasswordTextField.getText())) {
    	newAccount.setPassword(newPasswordTextField.getText());
    	newAccount.setFirstName(editFirstNameTextfield.getText());
    	newAccount.setLastName(editLastNameTextField.getText());
    	newAccount.setGender(editGenderTextField.getText());
    	newAccount.setAge(age);
    	
    	String a = "Account updated!";
		String b = "Press ok";
		
		ModalDialog dialog_D = new ModalDialog(a, b);
		Optional<ButtonType> result_R = dialog_D.showAndWait();
		if(result_R.isPresent()) {
			if(result_R.get() == ButtonType.OK) {
				
				Stage stageEdit = (Stage) saveChanges.getScene().getWindow();
				stageEdit.close();
				
				openScene(PERSISTANCE_NAME_ACCOUNT);
				
				System.out.println("Dialog ok");
					}
				}
		
    	} else {
    		String first = "Check the fields!";
			String second = "Try again";
			
			ModalDialog dialog = new ModalDialog(first, second);
    		Optional<ButtonType> result = dialog.showAndWait();
			if(result.isPresent()) {
    			if(result.get() == ButtonType.OK) {
    				
    				Stage stageEdit = (Stage) saveChanges.getScene().getWindow();
    				stageEdit.close();
    				
    				openScene(PERSISTANCE_NAME_EDIT_ACCOUNT);
    				
    				System.out.println("Dialog ok");
    						}
						}
    	}
    	
    	accountRepository.updateAccount(newAccount);
    	accountList.add(newAccount);
	}
	
    
}
