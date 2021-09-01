package teamD.publicParking.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import teamD.publicParking.search.model.SearchEntity;
import teamD.publicParking.search.model.SeoulParking;
import teamD.publicParking.search.repository.SearchForJpaRepository;
import teamD.publicParking.search.repository.SearchMybatisDao;

@Controller
@Slf4j
@RequestMapping("/se")
public class SearchController {
	
	// @Autowired
	//SearchJpaRepository parkingRepository;
	
	@Autowired
	SearchMybatisDao parkingRepository;
	
	@GetMapping({"/index", "/home"})
	public String home(Model model) {
		log.debug("log SearchController.foo");
		List<SearchEntity> parkinglist = parkingRepository.select();
		System.out.println("sys SearchController.foo");
		model.addAttribute("parkinglist", parkinglist);
		log.debug("parkinglist = {}", parkinglist);
		return "/index";
	}
	
	// @RequestMapping(value="/", method = RequestMethod.GET)
	@GetMapping("/search")
	public String parkingcon(@RequestParam(name="parking_id") String parking_id , Model model) {
		log.debug("SearchController.search");
		// 화면에 표시되는 직원데이터를 가져오기 위함
		List<SearchEntity> parkinglist = parkingRepository.select();
		model.addAttribute("parkinglist", parkinglist);
		return "/index";
	}
	
	@GetMapping("/wanna-data")
	public String wannaData(Model model) {
		log.debug("wannaData");
		List<SearchEntity> parkings = parkingRepository.select();
		log.debug("parkinglist = {}", parkings);
		model.addAttribute("parkings", parkings);
		model.addAttribute("whyNot", "바인딩 왜 안해줌");
		
		SearchEntity foo = new SearchEntity();
		
		model.addAttribute("data", foo);
		
		return "/imJustWannaDataBinding";
	}
	
	@GetMapping("/just-data")
	@ResponseBody
	public List<SearchEntity> justData(Model model) {
		log.debug("justData");
		List<SearchEntity> parkinglist = parkingRepository.select();
		log.debug("parkinglist = {}", parkinglist);
		model.addAttribute("parkinglist", parkinglist);
		return parkinglist;
	}
	
	@Autowired
	SearchForJpaRepository searchForJpaRepository;
	
	@GetMapping("/jpa/wanna-data")
	public String wanaDataJpa(Model model) {
		log.debug("wanaDataJpa");
		List<SeoulParking> parkings = searchForJpaRepository.findAll();
		log.debug("parkinglist = {}", parkings);
		return "/imJustWannaDataBinding";
	}
	
	//findOne
	
	@GetMapping("/jpa/just-one")
	public String wanaDataOneJpa(Model model) {
		log.debug(">>>>>>>>>> wanaDataOne");
		SeoulParking parking = searchForJpaRepository.findOne();
		model.addAttribute("data", parking);
		log.debug("parkinglist = {}", parking);
		return "/imJustWannaDataBindingOne";
	}
	
}