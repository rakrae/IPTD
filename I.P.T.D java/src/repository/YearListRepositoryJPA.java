package repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.YearList;

public class YearListRepositoryJPA implements YearListRepository {
	
	private static final String PERSISTANCE_UNIT_NAME = "IPTD";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("IPTD");
	private static final EntityManager em = emf.createEntityManager();
	
	@Override
	public void add(YearList yearList) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(yearList);
		et.commit();
		
	}

	@Override
	public Optional<YearList> read(long id) {

		YearList yearList = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		yearList = em.find(YearList.class, id);
		et.commit();
		
		
		return Optional.ofNullable(yearList);
	}
	
	@Override
	public List<YearList> readAll() {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		List<YearList> yearLists = (List<YearList>) em.createQuery("SELECT y FROM YearList y").getResultList();
		et.commit();
		
		
		return yearLists;
	}

	@Override
	public YearList updateList(YearList yearList) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		YearList mergedYearList = em.merge(yearList);
		et.commit();
		
		return yearList;
	}

	@Override
	public void delete(YearList yearList) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(yearList);
		et.commit();
		
	}

	

}
