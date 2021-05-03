package repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Target;

public class TargetRepositoryJPA implements TargetRepository {

	private static final String PERSISTANCE_UNIT_NAME = "IPTD";
	
	@Override
	public void add(Target target) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(target);
		et.commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public Optional<Target> read(long id) {
		
		Target targetTA = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		targetTA = em.find(Target.class, id);
		et.commit();
		
		em.close();
		emf.close();
		
		return Optional.ofNullable(targetTA);
	}

	@Override
	public List<Target> readAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		@SuppressWarnings("unchecked")
		List<Target> targets = (List<Target>) em.createQuery("SELECT t FROM Target t").getResultList();
		et.commit();
		
		em.close();
		emf.close();
		
		return targets;
	}
	
	@Override
	public Target updateTarget(Target target) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Target mergedTarget = em.merge(target);
		et.commit();
		
		em.close();
		emf.close();
		
		return mergedTarget;
	}

	@Override
	public void delete(Target target) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(target);
		et.commit();
		
		em.close();
		emf.close();
		
	}

	

}
