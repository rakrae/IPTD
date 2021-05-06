package model;

import java.io.Serializable;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;


@Entity
@Access(AccessType.PROPERTY)
@NamedQuery(name = "readAllAccounts", query = "select ac from Account ac")
public class Account implements Serializable {

	
	private LongProperty id = new SimpleLongProperty();

	@Column(nullable = false, unique = true)
	private String account;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;

	// damit kannst du von Account auf yearList zugreifen kannst
	@OneToOne(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private YearList yearList;

	public Account() {
		
		this.id = new SimpleLongProperty();
	
	}

	public YearList getYearList() {
		return yearList;
	}

	public void setYearList(YearList yearList) {
		this.yearList = yearList;
	}

	public Account(long id,String account, String password, String firstName, String lastName, String gender, int age) {

		super();
		this.id = new SimpleLongProperty(id);
		this.account = account;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;

	}

	// Für die Datenbank
	public Account(long id, String account, String password, String firstName, String lastName, String gender, int age,
			YearList yearList) {
		super();
		this.id = new SimpleLongProperty(id);
		this.account = account;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.yearList = yearList;

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id.get();
	}

	public void setId(long id) {
		this.id.set(id);;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account id: " + id + "  account: " + account + "  password: " + password + "  firstName: " + firstName
				+ "  lastName: " + lastName + "  gender: " + gender + "  age: " + age + "  yearList: " + yearList;
	}

	
}
