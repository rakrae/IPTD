package controller;

import java.text.SimpleDateFormat;
import java.util.Properties;

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
import repository.IPTD_List_Repository;
import repository.IPTD_List_RepositoryJPA;
import repository.IPTD_Lists_Repository;
import repository.IPTD_Lists_RepositoryJPA;
import repository.TargetRepository;
import repository.TargetRepositoryJPA;

public class CommonProprietiesController {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	static AccountRepository accountRepository = new AccountRepositoryJPA();
	static ObservableList<Account> accountList = FXCollections.observableArrayList();
	static ObjectProperty<Account> selectedAccount = new SimpleObjectProperty<Account>();
	
	static IPTD_Lists_Repository iptd_lists_repository = new IPTD_Lists_RepositoryJPA();
	static ObservableList<YearList> iptdLists = FXCollections.observableArrayList();
	static ObjectProperty<YearList> selectedIPTDLists = new SimpleObjectProperty<YearList>();
	
	static IPTD_List_Repository iptd_list_repository = new IPTD_List_RepositoryJPA();
	static ObservableList<NewYearsResolution> iptdList = FXCollections.observableArrayList();
	static ObjectProperty<NewYearsResolution> selectedIPTDList = new SimpleObjectProperty<NewYearsResolution>();
	
	static TargetRepository targetRepository = new TargetRepositoryJPA();
	static ObservableList<Target> targetList = FXCollections.observableArrayList();
	static ObjectProperty<Target> selectedTarget = new SimpleObjectProperty<Target>();
}
