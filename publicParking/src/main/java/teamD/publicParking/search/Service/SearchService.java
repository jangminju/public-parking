package teamD.publicParking.search.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamD.publicParking.search.Model.SearchEntity;
import teamD.publicParking.search.Repository.SearchRepository;

@Service
public class SearchService{
	@Autowired
	SearchRepository parkingRepository;
	public List<SearchEntity> searchAll() {
		return parkingRepository.findAll();
	}
}
