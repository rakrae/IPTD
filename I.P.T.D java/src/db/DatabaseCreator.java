package db;

import java.sql.Statement;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Account;
import model.Comment;
import model.NewYearsResolution;
import model.Target;
import model.YearList;


public class DatabaseCreator {

	private static final String PERSISTANCE_NAME = "IPTD";

	public static void main(String[] args) {

		insertDummyData();

	}

	private static void createNewDatabase() {

	}

	private static void dropOldTable() {

	}

	private static void insertDummyData() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		List<Comment> commList = List.of(new Comment("Think about what you want"),
				new Comment("Figure out what do you need to be done to get it"),
				new Comment("Structure your plan to get it"), new Comment("Now work for it and be consistent"),
				new Comment("Remember to take breaks"));

		List<Target> targetList = List.of(new Target("Score at the Java Project", commList));

		List<NewYearsResolution> nyrList = List.of(new NewYearsResolution("2021", targetList));

		YearList yearList = new YearList(nyrList);

		Account account = new Account(0,"Rakrae", "whotherenow", "Adi", "Bihuneti", "Male", 27, yearList);
		
		
		et.begin();
		
		em.persist(account);
		
		et.commit();
		
		em.close();
		emf.close();

	}

}
