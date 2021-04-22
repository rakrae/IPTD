package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseCreator {

	private static final String PERSISTANCE_NAME = "jdbc:derby:IPTD; create=true; user=Adi; password=test";

	public static void main(String[] args) {

	}

	private static void createNewDatabase() {

		try {
			Connection con = DriverManager.getConnection(PERSISTANCE_NAME);
			System.out.println("Connection established");

			Statement stmt = con.createStatement();

			stmt.execute("CREATE TABLE ACCOUNT (id INTEGER NOT NULL GENERATED ALWAYS AS INDENTITY PRIMARY KEY, "
					+ "account VARCHAR()255, " + "password VARCHAR(255), " + "firstName VARCHAR(255), "
					+ "lastName VARCHAR(255), " + "gender VARCHAR(255), " + "age INTEGER NOT NULL)");

			System.out.println("New Table Account created");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void dropOldTable() {

		try {
			Connection con = DriverManager.getConnection(PERSISTANCE_NAME);
			System.out.println("Connection established");

			Statement stmt = con.createStatement();

			stmt.execute("DROP TABLE ACCOUNT");
			System.out.println("Table IPTD dropped");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insertDummyData() {

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
