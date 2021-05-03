package repository;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Comment;

public class CommentRepositoryJPA implements CommentRepository{
	
	private static final String PERSISTANCE_UNIT_NAME = "IPTD";
	
	@Override
	public void add(Comment comment) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(comment);
		et.commit();
		
		em.close();
		emf.close();
		
		System.out.println("Comment added");
	}

	@Override
	public Optional<Comment> read(long id) {
		
		Comment comm = null;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		comm = em.find(Comment.class, id);
		et.commit();
		
		em.close();
		emf.close();
		
		System.out.println("Comment read");
		
		return Optional.ofNullable(comm);
	}

	@Override
	public List<Comment> readAll() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Read all comments");
		
		et.begin();
		@SuppressWarnings("unchecked")
		List<Comment> comments =(List<Comment>) em.createQuery("SELECT c FROM Comment c").getResultList();
		et.commit();
		
		em.close();
		emf.close();
		
		return comments;
	}

	@Override
	public Comment updateComment(Comment comment) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Comment mergedComment = em.merge(comment);
		et.commit();
		
		em.close();
		emf.close();
		
		return mergedComment;
	}

	@Override
	public void delete(Comment comment) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(comment);
		et.commit();
		
		em.close();
		emf.close();
		
	}

}
