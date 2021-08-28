package teamD.publicParking.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import teamD.publicParking.search.Model.SearchEntity;
import teamD.publicParking.search.Repository.SearchRepository;


@Controller
public class SearchController {
	
	@Autowired
	SearchRepository parkingRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		List<SearchEntity> parkinglist = parkingRepository.findAll();
		model.addAttribute("parkinglist", parkinglist);
		return "index";
	}
	
	
	@RequestMapping(value="/parking", method = RequestMethod.GET)
	public String parkingcon(@RequestParam(name="parking_id") String parking_id , Model model) {
		// 화면에 표시되는 직원데이터를 가져오기 위함
		List<SearchEntity> parkinglist = parkingRepository.findByparking_id(parking_id);
		model.addAttribute("parking", parkinglist);
		return "index";
	}
}
