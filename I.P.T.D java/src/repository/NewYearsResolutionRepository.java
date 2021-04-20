package repository;

import java.util.List;
import java.util.Optional;

import model.NewYearsResolution;

public interface NewYearsResolutionRepository {
	
	void add(NewYearsResolution iptd_list);
	
	Optional<NewYearsResolution> read(long id);
	
	List<NewYearsResolution> readAll();
	
	NewYearsResolution updateList(NewYearsResolution iptd_list);
	
	void delete(NewYearsResolution iptd_list);
}
