package controller;

import java.text.SimpleDateFormat;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Comment;
import model.NewYearsResolution;
import model.YearList;
import model.Target;
import repository.AccountRepository;
import repository.AccountRepositoryJPA;
import repository.CommentRepository;
import repository.CommentRepositoryJPA;
import repository.NewYearsResolutionRepository;
import repository.NewYearsResolutionRepositoryJPA;
import repository.YearListRepository;
import repository.YearListRepositoryJPA;
import repository.TargetRepository;
import repository.TargetRepositoryJPA;

// in order for the other controllers to use the modal dialog and its methods it extends the ModalDialog class
public class CommonProprietiesController extends ModalDialog {
	
	// it 
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	// Scene's open source
	static final String PERSISTANCE_NAME_LOGIN = "/application/Login.fxml";
	static final String PERSISTANCE_NAME_ACCOUNT = "/application/Account.fxml";
	static final String PERSISTANCE_NAME_EDIT_ACCOUNT = "/application/EditAccount.fxml";
	static final String PERSISTANCE_NAME_NEW_ACCOUNT = "/application/NewAccount.fxml";
	static final String PERSISTANCE_NAME_NEWYEARS_RESOLUTION = "/application/NewYearsResolution.fxml";
	static final String PERSISTANCE_NAME_YEARLIST = "/application/YearList.fxml";
	static final String PERSISTANCE_NAME_TARGET = "/application/Target.fxml";

	// Account entity repository
	static AccountRepository accountRepository = new AccountRepositoryJPA();
	static ObservableList<Account> accountList = FXCollections.observableArrayList(accountRepository.readAll());
	static ObjectProperty<Account> selectedAccount = new SimpleObjectProperty<Account>();

	// YearList entity repository
	static YearListRepository yearListRepository = new YearListRepositoryJPA();
	static ObservableList<YearList> yearList = FXCollections.observableArrayList(yearListRepository.readAll());
	static ObjectProperty<YearList> selectedYearList = new SimpleObjectProperty<YearList>();

	// NewYearsResolution entity repository
	static NewYearsResolutionRepository nyrRepository = new NewYearsResolutionRepositoryJPA();
	static ObservableList<NewYearsResolution> nyrList = FXCollections.observableArrayList(nyrRepository.readAll());
	static ObjectProperty<NewYearsResolution> selectedNYR_List = new SimpleObjectProperty<NewYearsResolution>();

	// Target entity repository
	static TargetRepository targetRepository = new TargetRepositoryJPA();
	static ObservableList<Target> targetList = FXCollections.observableArrayList(targetRepository.readAll());
	static ObjectProperty<Target> selectedTarget = new SimpleObjectProperty<Target>();

	// Comment entity repository
	static CommentRepository commentRepository = new CommentRepositoryJPA();
	static ObservableList<Comment> commentList = FXCollections.observableArrayList(commentRepository.readAll());
	static ObjectProperty<Comment> selectedComment = new SimpleObjectProperty<Comment>();

	// simple method to open the scenes
	public void openScene(String scene) {

		try { // Hier wird die zweite Fenster geöffneta
			FXMLLoader mainLoader = new FXMLLoader();
			mainLoader.setLocation(getClass().getResource(scene));

			Parent root = (Parent) mainLoader.load();

			Scene mainScene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(mainScene);

			stage.show();
			stage.setOnHidden(null);

		} catch (Exception e) {
			System.err.println("Can not load");
			e.printStackTrace();
		}
	}

	
	// opens a scene and sets the first one on hidden
	public void openSceneOnHidden(String firstScene, Stage secondScene) {

		try { // Hier wird die zweite Fenster geöffneta
			FXMLLoader mainLoader = new FXMLLoader();
			mainLoader.setLocation(getClass().getResource(firstScene));

			Parent root = (Parent) mainLoader.load();

			Scene mainScene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(mainScene);

			stage.setOnHidden(e -> secondScene.show()); // in plus
			
			stage.show();
			stage.setOnHidden(null);

		} catch (Exception e) {
			System.err.println("Can not load");
			e.printStackTrace();
		}

	}

}
