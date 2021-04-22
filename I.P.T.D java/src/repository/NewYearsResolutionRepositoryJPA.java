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
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("IPTD");
	private static final EntityManager em = emf.createEntityManager();

	@Override
	public void add(NewYearsResolution newYearsResolution) {

		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(newYearsResolution);
		et.commit();

	}

	@Override
	public Optional<NewYearsResolution> read(long id) {

		NewYearsResolution nyr = null;
		EntityTransaction et = em.getTransaction();

		et.begin();
		nyr = em.find(NewYearsResolution.class, id);
		et.commit();

		return Optional.of(nyr);
	}

	@Override
	public List<NewYearsResolution> readAll() {

		EntityTransaction et = em.getTransaction();

		et.begin();
		List<NewYearsResolution> nyrs = (List<NewYearsResolution>) em.createQuery("SELECT n FROM NewYearsResolution n")
				.getResultList();
		et.commit();

		return nyrs;
	}

	@Override
	public NewYearsResolution updateList(NewYearsResolution newYearsResolution) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		NewYearsResolution mergedNYR = em.merge(newYearsResolution);
		et.commit();
		
		return mergedNYR;
	}

	@Override
	public void delete(NewYearsResolution newYearsResolution) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(newYearsResolution);
		et.commit();
		
	}

}
