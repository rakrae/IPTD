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
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
	private static final EntityManager em = emf.createEntityManager();
	
	@Override
	public void add(Comment comment) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(comment);
		et.commit();
		
		System.out.println("Comment added");
	}

	@Override
	public Optional<Comment> read(long id) {
		
		Comment comm = null;
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		comm = em.find(Comment.class, id);
		et.commit();
		
		System.out.println("Comment read");
		
		return Optional.ofNullable(comm);
	}

	@Override
	public List<Comment> readlAdd() {
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Read all comments");
		
		et.begin();
		List<Comment> comments =(List<Comment>) em.createQuery("SELECT c FROM Comment c").getResultList();
		et.commit();
		
		return comments;
	}

	@Override
	public Comment updateComment(Comment comment) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Comment mergedComment = em.merge(comment);
		et.commit();
		
		return mergedComment;
	}

	@Override
	public void delete(Comment comment) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(comment);
		et.commit();
		
		
	}

}
