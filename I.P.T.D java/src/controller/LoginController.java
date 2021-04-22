package controller;

import java.awt.DisplayMode;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    	
    	/*
    	 * if else statement wird hizugefügt um Konto zu 
    	 * überprüfen ob es schon gibt oder nicht und auch
    	 * für die korretheit der Daten
    	 * 
    	 */
    	
    	
    	try { // Hier wird die zweite Fenster geöffnet

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/Account.fxml"));

			Parent root = (Parent) loader.load();

			
			AccountController ctr = loader.getController(); 	
													
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			
//			stage.setOnHidden(e -> primaryStage.show()); // in plus
			
			stage.show();
			
			primaryStage.hide();
				
			
		} catch (Exception e) {
			System.err.println("Can not load Account");
			e.printStackTrace();
		}
    	
    	
    	
    }

    @FXML
    void handleNewAccountPressed(ActionEvent event) {
    	
    	Stage primaryStage = (Stage) passwordTextField.getScene().getWindow();
    	primaryStage.close();
    	
    	try { // Hier wird die zweite Fenster geöffnet

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/NewAccount.fxml"));

			Parent root = (Parent) loader.load();

			NewAccountController ctr = loader.getController(); 	
													
							

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			
//			stage.setOnHidden(e -> primaryStage.show()); // in plus
			
			stage.show();
			
			primaryStage.hide(); // dazu
			
		} catch (Exception e) {
			System.err.println("Can not load New Account");
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
        assert closeProgramm != null : "fx:id=\"closeProgramm\" was not injected: check your FXML file 'Login.fxml'.";
        assert accountTextField != null : "fx:id=\"accountTextField\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert newAccount != null : "fx:id=\"newAccount\" was not injected: check your FXML file 'Login.fxml'.";

    }
}