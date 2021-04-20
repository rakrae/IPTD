package controller;

import java.text.SimpleDateFormat;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import model.Account;
import model.NewYearsResolution;
import model.YearList;
import model.Target;
import repository.AccountRepository;
import repository.AccountRepositoryJPA;
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
	
	static YearListRepository iptd_lists_repository = new YearListRepositoryJPA();
	static ObservableList<YearList> iptdLists = FXCollections.observableArrayList();
	static ObjectProperty<YearList> selectedIPTDLists = new SimpleObjectProperty<YearList>();
	
	static NewYearsResolutionRepository iptd_list_repository = new NewYearsResolutionRepositoryJPA();
	static ObservableList<NewYearsResolution> iptdList = FXCollections.observableArrayList();
	static ObjectProperty<NewYearsResolution> selectedIPTDList = new SimpleObjectProperty<NewYearsResolution>();
	
	static TargetRepository targetRepository = new TargetRepositoryJPA();
	static ObservableList<Target> targetList = FXCollections.observableArrayList();
	static ObjectProperty<Target> selectedTarget = new SimpleObjectProperty<Target>();
}
