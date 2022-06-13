package com.collective.Plants.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collective.Plants.Repository.PlantsRepository;
import com.collective.Plants.model.Plants;

@RestController
public class PlantsController {

	@Autowired
	private PlantsRepository repo;

	// Creation of plants Api
	@RequestMapping(value = "/plants", method = RequestMethod.POST)
	public ResponseEntity<Plants> postPlants(@RequestBody Plants plants) {
		try {
			Plants p = repo.save(new Plants(plants.getYear(), plants.getPlant(), plants.getPlantname(),
					plants.getGenid(), plants.getGenstat(), plants.getGenntan(), false));
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get all plants Api
	@GetMapping("getAllPlants")
	public ResponseEntity<List<Plants>> getAllPlants() {
		List<Plants> plants = new ArrayList<Plants>();
		repo.findAll().forEach(plants::add);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	//Ability to display top N and Bottom n plants in either ASC or DSC order by total generation output
	//http://localhost:8080/dubaiplants/getplants?id=desc
	//http://localhost:8080/dubaiplants/getplants?id=asc
	
	@GetMapping("getplants")
	public ResponseEntity<List<Plants>> getPlants(@RequestParam(required = false) String id) { 
		List<Plants> plants = new ArrayList<Plants>();
		if(id.equalsIgnoreCase("asc")) {
		repo.findPlantsByAscorder().forEach(plants::add);
		} else if(id.equalsIgnoreCase("desc")) {
			repo.findPlantsByDscorder().forEach(plants::add);
		}
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	//get plants by location
	//http://localhost:8080/dubaiplants/getplantsByLocation?location=AK
	//http://localhost:8080/dubaiplants/getplantsByLocation?location=AK&pageNo=0&pageSize=1
	
	
	@GetMapping("getplantsByLocation")
	public ResponseEntity<List<Plants>> getPlantsBylocation(@RequestParam(required = false) String location,
			@RequestParam(defaultValue = "0") Integer pageNo,
			 @RequestParam(defaultValue = "1") Integer pageSize) { 
		
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		List<Plants> plants = new ArrayList<Plants>();
		 repo.findPlantsBylocation(paging,location).forEach(plants::add);
		return new ResponseEntity<>(plants, HttpStatus.OK);

		//List<Plants> plants = new ArrayList<Plants>();
		//repo.findPlantsBylocation(location).forEach(plants::add);
		//return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	

	// Get plant details
	//http://localhost:8080/dubaiplants/getplantdetails?plantname=Ambler
	@GetMapping("getplantdetails")
	public ResponseEntity<List<Plants>> getAllPlants(@RequestParam(required = false) String plantname) {
		List<Plants> plants = new ArrayList<Plants>();
		 repo.findPlantDetails(plantname).forEach(plants::add);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

}
