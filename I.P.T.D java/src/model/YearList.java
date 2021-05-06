package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.WritableLongValue;


@Entity
@Access(AccessType.PROPERTY)
@NamedQuery(name = "readAllYearLists", query = "select yl from YearList yl")
public class YearList implements Serializable{
	
	
	private LongProperty id = new SimpleLongProperty();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<NewYearsResolution> lists = new ArrayList<NewYearsResolution>();
	
	private ObjectProperty<Account> account;
	
	public YearList() {};
	
	public YearList(YearList yearList) {
		this.id.set(yearList.getId());
	};
	
	public YearList(long id,List<NewYearsResolution> lists) {
		super();
		this.id = new SimpleLongProperty(id);
		this.lists = lists;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id.get();
	}

	public void setId(long id) {
		this.id.set(id);;
	}
	
	public final ObjectProperty<Account> accountProperty(){
		return this.account;
	}

	@OneToOne
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return this.accountProperty().get();
	}

	public void setAccount(final Account account) {
		this.account.set(account);;
	}

	
	
	
	public YearList(List<NewYearsResolution> lists) {
		super();
		this.lists = lists;
	}
	
	
	public List<NewYearsResolution> getLists() {
		return lists;
	}

	public void setLists(List<NewYearsResolution> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "YearList id: " + id + "  lists: " + lists;
	}

	
}
