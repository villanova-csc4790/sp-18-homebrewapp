package io.alexaggs.project.beer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomebrewService {
	
	@Autowired
	HomebrewRepository repository;
	
	public List<HomebrewBeer> getAllBeers() {
		List<HomebrewBeer> beers = new ArrayList<HomebrewBeer>();
		repository.findAll().forEach(beers::add);
		return beers;
	}
	
	public HomebrewBeer getBeer(String id) {
		return repository.findOne(id);
	}

	public void addBeer(HomebrewBeer beer) {
		repository.save(beer);
	}
	
	public void updateBeer(HomebrewBeer beer, String id) {
		repository.save(beer);
	}
	
	public void deleteBeer(String id) {
		repository.delete(getBeer(id));
	}
}
