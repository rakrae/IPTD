package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name = "readAllTargets", query = "select t from Target t")
public class Target implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String targetName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Target() {}

	public Target(long id, String targetName, List<Comment> comments) {
		super();
		this.id = id;
		this.targetName = targetName;
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public void addComment(String addComment) {

	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Target id: " + id + "  targetName: " + targetName + "  comments: " + comments;
	}

	/*
	 * There should be a countdown method which comes along each target that is
	 * added to the New Year's Resolution List
	 * 
	 */

}
