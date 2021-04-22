package controller;

import java.text.SimpleDateFormat;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
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

public class CommonProprietiesController {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	static AccountRepository accountRepository = new AccountRepositoryJPA();
	static ObservableList<Account> accountList = FXCollections.observableArrayList();
	static ObjectProperty<Account> selectedAccount = new SimpleObjectProperty<Account>();
	
	
	static YearListRepository yearListrepository = new YearListRepositoryJPA();
	static ObservableList<YearList> yearList = FXCollections.observableArrayList();
	static ObjectProperty<YearList> selectedYearList = new SimpleObjectProperty<YearList>();
	
	
	static NewYearsResolutionRepository nyrRepository = new NewYearsResolutionRepositoryJPA();
	static ObservableList<NewYearsResolution> nyrList = FXCollections.observableArrayList(nyrRepository.readAll());
	static ObjectProperty<NewYearsResolution> selectedNYR_List = new SimpleObjectProperty<NewYearsResolution>();
	
	
	static TargetRepository targetRepository = new TargetRepositoryJPA();
	static ObservableList<Target> targetList = FXCollections.observableArrayList();
	static ObjectProperty<Target> selectedTarget = new SimpleObjectProperty<Target>();
	
	
	static CommentRepository commentRepository = new CommentRepositoryJPA();
	static ObservableList<Comment> commentList = FXCollections.observableArrayList();
	static ObjectProperty<Comment> selectedComment = new SimpleObjectProperty<Comment>();
	
}
