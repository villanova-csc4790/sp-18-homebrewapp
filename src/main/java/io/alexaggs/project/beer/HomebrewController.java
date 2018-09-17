package io.alexaggs.project.beer;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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
		return hbService.getBeer(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/homebrews")
	public void addBeer(@RequestBody HomebrewBeer beer) {
		hbService.addBeer(beer);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/homebrews/{id}")
	public void updateBeer(@RequestBody HomebrewBeer beer, @PathVariable String id) {
		hbService.updateBeer(beer, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/homebrews/{id}")
	public void deleteBeer(@PathVariable String id) {
		hbService.deleteBeer(id);
	}
}
