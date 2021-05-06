package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.YearList;

public class YearListRepositoryJPA implements YearListRepository {
	
	private static final String PERSISTANCE_UNIT_NAME = "IPTD";
	
	@Override
	public void add(YearList yearList) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(yearList);
		et.commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public Optional<YearList> read(long id) {

		YearList yearList = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		yearList = em.find(YearList.class, id);
		et.commit();
		
		em.close();
		emf.close();
		
		return Optional.ofNullable(yearList);
	}
	
	@Override
	public List<YearList> readAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		List<YearList> yearLists = new ArrayList<>();
		
		TypedQuery<YearList> query = em.createNamedQuery("readAllYearLists", YearList.class);
		yearLists = query.getResultList();
		
		et.commit();
		
		em.close();
		emf.close();
		
		return yearLists;
	}

	@Override
	public YearList updateList(YearList yearList) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		YearList mergedYearList = em.merge(yearList);
		et.commit();
		
		em.close();
		emf.close();
		
		return mergedYearList;
	}

	@Override
	public void delete(YearList yearList) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(yearList);
		et.commit();
		
		em.close();
		emf.close();
		
	}

	

}
