package controller;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class ModalDialog extends Dialog<ButtonType> {
	
	String text1 = null;
	String text2 = null;

	public ModalDialog(String text1, String text2) {
		
		super();
		this.text1 = text1;
		this.text2 = text2;
		
		this.setHeaderText(text1);
		this.setContentText(text2);
		this.getDialogPane().getButtonTypes().add(ButtonType.OK);
		this.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
	
	}
	
	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	
	
	
	
	
}
