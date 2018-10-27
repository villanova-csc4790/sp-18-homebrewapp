package io.alexaggs.project.CommercialBeer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommercialBeerService {

    @Autowired
    CommercialBeerRepository repository;

    private int idCount = 0;
    private String count = "";

    public List<CommercialBeer> getAllBeers() {
        List<CommercialBeer> beers = new ArrayList<CommercialBeer>();
        repository.findAll().forEach(beers::add);
        return beers;
    }

    public CommercialBeer getBeer(String id) {
        return repository.findOne(id);
    }

    public void addBeer(CommercialBeer beer) {
        count = String.valueOf(idCount);
        idCount++;
        beer.setCBId(count);
        repository.save(beer);
    }

    public void updateBeer(CommercialBeer beer, String id) {
        repository.save(beer);
    }

    public void deleteBeer(String id) {
        idCount--;
        repository.delete(getBeer(id));
    }
}
