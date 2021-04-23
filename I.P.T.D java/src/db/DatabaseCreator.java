package db;

import java.sql.Statement;

import model.Account;
import repository.AccountRepository;
import repository.AccountRepositoryJPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseCreator {

	private static final String PERSISTANCE_NAME = "jdbc:derby:IPTD; create=true; user=Adi; password=test";

	public static void main(String[] args) {
		
		insertDummyData();
		
		
	}

	private static void createNewDatabase() {

	}

	private static void dropOldTable() {

		
	}

	private static void insertDummyData() {

		AccountRepository repository = new AccountRepositoryJPA();
		
		Account account = new Account();
		repository.add(account);
		
		try {
			Connection con = DriverManager.getConnection(PERSISTANCE_NAME);
			System.out.println("Connection established");

			PreparedStatement pStmt = con.prepareStatement(
					"INSERT INTO ACCOUNT (account, password, firstName, lastName, gender, age) VALUES (?, ?, ?, ?, ?, ?)");

			pStmt.setString(1, "Rakrae");
			pStmt.setString(2, "Adi");
			pStmt.setString(3, "Bihuneti");
			pStmt.setString(4, "Male");
			pStmt.setInt(5, 27);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
