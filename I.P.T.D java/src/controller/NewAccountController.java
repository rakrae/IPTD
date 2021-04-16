package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewAccountController {

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
    	
		try { // Hier wird die zweite Fenster geöffnet

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Login.fxml"));

			Parent root = (Parent) loader.load();


			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			
//			stage.setOnHidden(e -> newStage.show()); // in plus
			
			stage.show();
			
			stageLogin.hide();
			
		 // dazu
			
		} catch (Exception e) {
			System.err.println("Can not load Login");
			e.printStackTrace();
		}
		
		
    }

    @FXML
    void handleCreateAccountPressed(ActionEvent event) {

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
