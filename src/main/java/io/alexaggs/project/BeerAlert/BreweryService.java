package io.alexaggs.project.BeerAlert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreweryService {

    @Autowired
    BreweryRepository repository;

    private int idCount = 0;
    private String count = "";

    public List<Brewery> getAllBeers() {
        List<Brewery> beers = new ArrayList<Brewery>();
        repository.findAll().forEach(beers::add);
        return beers;
    }

    public Brewery getBrewery(String id) {
        return repository.findOne(id);
    }

    public void addBrewery(Brewery b) {
        count = String.valueOf(idCount);
        idCount++;
        b.setId(count);
        repository.save(b);
    }

    public void updateBrewery(Brewery b, String id) {
        repository.save(b);
    }

    public void deleteBrewery(String id) {
        idCount--;
        repository.delete(getBrewery(id));
    }
}