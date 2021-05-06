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
		
		List<Comment> commList = List.of(new Comment(0l,"Think about what you want"),
				new Comment(0l,"Figure out what do you need to be done to get it"),
				new Comment(0l,"Structure your plan to get it"), new Comment(0l,"Now work for it and be consistent"),
				new Comment(0l,"Remember to take breaks"));

		List<Target> targetList = List.of(new Target(0l,"Score at the Java Project", commList));

		List<NewYearsResolution> nyrList = List.of(new NewYearsResolution(0l,"2021", targetList));

		YearList yearList = new YearList(0l,nyrList);

		Account account = new Account(1l,"Rakrae", "whotherenow", "Adi", "Bihuneti", "Male", 27, yearList);
		
		
		et.begin();
		
		em.persist(account);
		
		et.commit();
		
		em.close();
		emf.close();

	}

}
