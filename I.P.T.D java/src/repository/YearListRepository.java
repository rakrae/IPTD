package repository;

import java.util.List;
import java.util.Optional;

import model.YearList;

public interface YearListRepository {
	
	void add(YearList iptd_lists);
	
	Optional<YearList> read(long id);
	
	List<YearList> readAll();
	
	YearList updateList(YearList iptd_lists);
	
	void delete(YearList iptd_lists);
	
}
