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


@Entity
@NamedQuery(name = "readAllYearLists", query = "select yl from YearList yl")
public class YearList implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<NewYearsResolution> lists = new ArrayList<NewYearsResolution>();
	
	
	public YearList() {};
	
	public YearList(long id,List<NewYearsResolution> lists) {
		super();
		this.id = id;
		this.lists = lists;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
