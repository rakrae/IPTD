package repository;

import java.util.List;
import java.util.Optional;

import model.YearList;

public interface YearListRepository {
	
	void add(YearList yearList);
	
	Optional<YearList> read(long id);
	
	List<YearList> readAll();
	
	YearList updateList(YearList yearList);
	
	void delete(YearList yearList);
	
}
