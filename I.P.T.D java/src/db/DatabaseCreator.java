package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCreator {

	public static void main(String[] args) {
		
		
		

	}
	
	private static void dropOldTable() {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:derby:IPTD; create=true; user=Adi; password=test");
			System.out.println("Connection established");
			
			Statement stmt = con.createStatement();
			
			stmt.execute("DROP TABLE IPTD");
			System.out.println("Table IPTD dropped");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void createNewDatabase() {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:derby:IPTD; create=true; user=Adi; password=test");
			System.out.println("Connection established");
			
			Statement stmt = con.createStatement();
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void insertDummyData() {
		
		
	}

}
