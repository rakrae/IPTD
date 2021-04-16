package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewYearsResolution implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String iptdListName;
	private List<Target> targets = new ArrayList<>();
	
	public NewYearsResolution(long id, String iptdListName, List<Target> targets) {
		super();
		this.id = id;
		this.iptdListName = iptdListName;
		this.targets = targets;
	}

	public String getIptdListName() {
		return iptdListName;
	}

	public void setIptdListName(String iptdListName) {
		this.iptdListName = iptdListName;
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	
	
	
	
}
