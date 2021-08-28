package teamD.publicParking.search.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teamD.publicParking.search.Model.SearchEntity;


@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, String>{
	public static final String querybase
	= "SELECT"
	+ " seoul_parking.parking_id"
	+ " , seoul_parking.parking_name"
	+ " , seoul_parking.parking_address"
	+ " , seoul_parking.parking_phone"
	+ " FROM"
	+ " teamD.seoul_parking parking_id "
	+ " ON seoul_parking.parking_id = seoul_parking.parking_id"
	;
	
	public static final String _query =  querybase
			+ " ORDER BY"
			+ " seoul_parking.parking_id";
	
	public static final String _query2 =  querybase
			+ " WHERE "
			+ " seoul_parking.parking_id = :parking_id"
			+ " ORDER BY"
			+ " seoul_parking.parking_id, seoul_parking.parking_id";
	
	@Query(value= _query, nativeQuery = true)
	List<SearchEntity> findAll();
	@Query(value= _query2, nativeQuery = true)
	List<SearchEntity> findByparking_id(@Param("parking_id") String parking_id);
	
}
