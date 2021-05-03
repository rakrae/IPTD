package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


@Entity
@NamedQuery(name = "readAllYearLists", query = "select yl from YearList yl")
public class YearList implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany
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

	@Override
	public String toString() {
		return "YearList id: " + id + "  lists: " + lists;
	}

	
}
