package repository;

import java.util.List;
import java.util.Optional;

import model.Comment;

public interface CommentRepository {
	
	void add(Comment comment);
	
	Optional<Comment> read(long id);
	
	List<Comment> readAll();
	
	Comment updateComment(Comment comment);
	
	void delete(Comment comment);
	
}
