package controller;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class ModalDialog extends Dialog<ButtonType> {
	
	public ModalDialog() {
		
		/*
		 * It is not ready yet and still
		 * working on it
		 * 
		 */
		
		this.setHeaderText("Account succesfully created!");
		this.setContentText("Press ok and login");
		this.getDialogPane().getButtonTypes().add(ButtonType.OK);
		
	}
	
	
	public void dialog() {
		/*
		 * 
		 * Testing !!!
		 * 
		 */
		
		this.setHeaderText("Account succesfully created!");
		this.setContentText("Press ok and login");
		this.getDialogPane().getButtonTypes().add(ButtonType.OK);
	}
	
	
	
	
}
