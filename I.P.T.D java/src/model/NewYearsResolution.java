package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;

@Entity
@NamedQuery(name = "readAllNYRResolutions", query = "select nyr from NewYearsResolution nyr")
public class NewYearsResolution implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String newYearsResolutionName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Target> targets = new ArrayList<>();
	
	public NewYearsResolution() {}

	public NewYearsResolution(long id, String nyrName, List<Target> targets) {
		super();
		this.id = id;
		this.newYearsResolutionName = nyrName;
		this.targets = targets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNewYearsResolutionName() {
		return newYearsResolutionName;
	}

	public void setNewYearsResolutionName(String nyrName) {
		this.newYearsResolutionName = nyrName;
	}

	
	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	@Override
	public String toString() {
		return "NewYearsResolution id: " + id + "  newYearsResolutionName: " + newYearsResolutionName + "  targets: "
				+ targets;
	}
	
	/*
	 * Here comes the countdown method for each list created
	 * 
	 */
	
	
}
