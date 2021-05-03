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
public class NewYearsResolution implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String newYearsResolutionName;
	
	@OneToMany
	private List<Target> targets = new ArrayList<>();
	
	public NewYearsResolution() {}
	
	public NewYearsResolution(long id, String nyrName, List<Target> targets) {
		super();
		this.id = id;
		this.newYearsResolutionName = nyrName;
		this.targets = targets;
	}
	
	public NewYearsResolution(String nyrName, List<Target> targets) {
		super();
		this.newYearsResolutionName = nyrName;
		this.targets = targets;
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
