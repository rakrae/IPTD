package repository;

import java.util.List;
import java.util.Optional;

import model.Target;

public interface TargetRepository {
	
	void add(Target target);
	
	Optional<Target> read(long id);
	
	List<Target> readAll();
	
	Target updateTarget(Target target);
	
	void delete(Target target);

}
