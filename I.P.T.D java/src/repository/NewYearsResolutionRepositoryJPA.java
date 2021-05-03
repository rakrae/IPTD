package repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.NewYearsResolution;

public class NewYearsResolutionRepositoryJPA implements NewYearsResolutionRepository {

	private static final String PERSISTANCE_UNIT_NAME = "IPTD";

	@Override
	public void add(NewYearsResolution newYearsResolution) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(newYearsResolution);
		et.commit();
		
		em.close();
		emf.close();
		
		System.out.println("NewYearsResolution added");

	}

	@Override
	public Optional<NewYearsResolution> read(long id) {

		NewYearsResolution nyr = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();

		et.begin();
		nyr = em.find(NewYearsResolution.class, id);
		et.commit();
		
		em.close();
		emf.close();
		
		return Optional.of(nyr);
	}

	@Override
	public List<NewYearsResolution> readAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();
		@SuppressWarnings("unchecked")
		List<NewYearsResolution> nyrs = (List<NewYearsResolution>) em.createQuery("SELECT n FROM NewYearsResolution n")
				.getResultList();
		et.commit();

		em.close();
		emf.close();
		
		return nyrs;
	}

	@Override
	public NewYearsResolution updateList(NewYearsResolution newYearsResolution) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		NewYearsResolution mergedNYR = em.merge(newYearsResolution);
		et.commit();
		
		em.close();
		emf.close();
		
		return mergedNYR;
	}

	@Override
	public void delete(NewYearsResolution newYearsResolution) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(newYearsResolution);
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
