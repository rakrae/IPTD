package repository;

import java.util.List;
import java.util.Optional;

import model.NewYearsResolution;

public interface NewYearsResolutionRepository {
	
	void add(NewYearsResolution newYearsResolution);
	
	Optional<NewYearsResolution> read(long id);
	
	List<NewYearsResolution> readAll();
	
	NewYearsResolution updateList(NewYearsResolution newYearsResolution);
	
	void delete(NewYearsResolution newYearsResolution);
}
