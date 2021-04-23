package controller;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class ModalDialog extends Dialog<ButtonType> {
	
	public ModalDialog() {
		
		this.setContentText("Excelent");
		this.setHeaderText("Task");
		this.getDialogPane().getButtonTypes().add(ButtonType.OK);
		this.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		
	}
	
	
}
