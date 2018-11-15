package io.alexaggs.project.HomebrewBeer;

import java.util.ArrayList;
import java.util.List;

import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomebrewController {
	
	@Autowired
	private HomebrewService hbService;

	@RequestMapping("/homebrews")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<HomebrewBeer> getAllBeers() {
		return hbService.getAllBeers();
	}

	@RequestMapping("/homebrews/{id}")
	public HomebrewBeer getBeer(@PathVariable String id) {
		System.out.println("GET");
		return hbService.getBeer(id);
	}

	@RequestMapping(method = RequestMethod.POST, value="/homebrews")
	@CrossOrigin(origins = "http://localhost:3000")
	public void addBeer(@RequestBody HomebrewBeer beer) throws Exception {
		System.out.println("POST");
		try {
			beer.setAvgAbv(CommercialBeerScraper.getAvgAbvs(beer.getBeerStyle()));
		} catch(Exception e) {
			beer.setAvgAbv(0.0);
		}
		hbService.addBeer(beer);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/homebrews/{id}")
	public void updateBeer(@RequestBody HomebrewBeer beer, @PathVariable String id) {
		System.out.println("Put");
		hbService.updateBeer(beer, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/homebrews/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteBeer(@PathVariable String id) {
		System.out.println("Delete");
		hbService.deleteBeer(id);
	}
}
