package teamD.publicParking.search.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamD.publicParking.search.model.SearchEntity;

@Repository
public class SearchMybatisDaoImpl implements SearchMybatisDao {

	private SearchMybatisDao mapper;

	@Autowired
	public SearchMybatisDaoImpl(SqlSession sqlSession) {
		this.mapper = sqlSession.getMapper(SearchMybatisDao.class);
	}

	@Override
	public List<SearchEntity> select() {
		return mapper.select();
	}
	
	@Override
	public List<SearchEntity> searchByCondition(String area, String address) {
		return mapper.searchByCondition(area, address);
	}
}
