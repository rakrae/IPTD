package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import application.Main;
import controller.AccountController;
import controller.CommonProprietiesController;
import controller.EditAccountController;
import controller.LoginController;
import controller.ModalDialog;
import controller.NewAccountController;
import controller.NewYearsResolutionController;
import controller.TargetController;
import controller.YearList_Controller;
import model.Account;
import model.Comment;
import model.NewYearsResolution;
import model.Target;
import model.YearList;
import repository.AccountRepositoryJPA;
import repository.CommentRepositoryJPA;
import repository.NewYearsResolutionRepositoryJPA;
import repository.TargetRepositoryJPA;
import repository.YearListRepositoryJPA;

class IPTD_Test {

	@Test
	void testClasses() {
		
		Main main = new Main();
		
		Account account = new Account();
		
		YearList yearList = new YearList();
		
		NewYearsResolution nyr = new NewYearsResolution();
		
		Target target = new Target();
		
		Comment comm = new Comment();
		
		AccountController ac = new AccountController();
		
		CommonProprietiesController cpc = new CommonProprietiesController();
		
		EditAccountController eac = new EditAccountController();
		
		LoginController lc = new LoginController();
		
		ModalDialog md = new ModalDialog(null, null);
		
		NewAccountController nac = new NewAccountController();
		
		NewYearsResolutionController nyrc = new NewYearsResolutionController();
		
		TargetController tc = new TargetController();
		
		YearList_Controller ylc = new YearList_Controller();
		
		AccountRepositoryJPA arj = new AccountRepositoryJPA();
		
		CommentRepositoryJPA crj = new CommentRepositoryJPA();
		
		NewYearsResolutionRepositoryJPA nyrj = new NewYearsResolutionRepositoryJPA();
		
		TargetRepositoryJPA trj = new TargetRepositoryJPA();
		
		YearListRepositoryJPA ylrj = new YearListRepositoryJPA();
		
		
	}

}
