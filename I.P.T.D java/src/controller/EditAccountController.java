package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
		
		try { // Hier wird die zweite Fenster geöffnet

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Account.fxml"));

			Parent root = (Parent) loader.load();


			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			
//			stage.setOnHidden(e -> newStage.show()); // in plus
			
			stage.show();
			
			stageEdit.hide();
			
		 // dazu
			
		} catch (Exception e) {
			System.err.println("Can not load Account");
			e.printStackTrace();
		}
		
    	
    }

    @FXML
    void handleSaveChangedPressed(ActionEvent event) {

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

    }
}
