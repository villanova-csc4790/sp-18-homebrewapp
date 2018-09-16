package io.alexaggs.project.beer;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomebrewController {
	
	@Autowired
	private HomebrewService topService;

	@RequestMapping("/homebrews")
	public List<HomebrewBeer> getAllBeers() {
		return topService.getAllBeers();
	}
	
	@RequestMapping("/homebrews/{id}")
	public HomebrewBeer getBeer(@PathVariable String id) {
		return topService.getBeer(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/homebrews")
	public void addBeer(@RequestBody HomebrewBeer beer) {
		topService.addBeer(beer);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/homebrews/{id}")
	public void updateBeer(@RequestBody HomebrewBeer beer, @PathVariable String id) {
		topService.updateBeer(beer, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/homebrews/{id}")
	public void deleteBeer(@PathVariable String id) {
		topService.deleteBeer(id);
	}
}
