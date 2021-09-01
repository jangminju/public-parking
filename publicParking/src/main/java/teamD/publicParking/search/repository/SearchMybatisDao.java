package teamD.publicParking.search.repository;

import java.util.List;

import teamD.publicParking.search.model.SearchEntity;

public interface SearchMybatisDao {

	List<SearchEntity> select();
	
	List<SearchEntity> searchByCondition(String area, String address);
}
