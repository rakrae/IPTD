package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class YearList implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "account")
	private Account account;
	
	@OneToMany // 1 - N
	private List<NewYearsResolution> lists = new ArrayList<NewYearsResolution>();

	public YearList() {};
	
	public YearList(long id,List<NewYearsResolution> lists) {
		super();
		this.id = id;
		this.lists = lists;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
