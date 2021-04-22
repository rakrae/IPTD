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
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("IPTD");
	private static final EntityManager em = emf.createEntityManager();
	
	@Override
	public void add(Target target) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(target);
		et.commit();
		
	}

	@Override
	public Optional<Target> read(long id) {
		
		Target targetTA = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		targetTA = em.find(Target.class, id);
		et.commit();
		
		return Optional.ofNullable(targetTA);
	}

	@Override
	public List<Target> readAll() {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		List<Target> targets = (List<Target>) em.createQuery("SELECT t FROM Target t").getResultList();
		et.commit();
		
		return targets;
	}
	
	@Override
	public Target updateTarget(Target target) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Target mergedTarget = em.merge(target);
		et.commit();
		
		
		return mergedTarget;
	}

	@Override
	public void delete(Target target) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(target);
		et.commit();
		
	}

	

}
