package io.alexaggs.project.BeerAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepo city;

    private int idCount = 0;
    private String count = "";

    public List<City> getAllCities() {
        List<City> beers = new ArrayList<City>();
        city.findAll().forEach(beers::add);
        return beers;
    }

    public City getCity(String id) {
        return city.findOne(id);
    }

    public void addCity(City city) {
        if(getAllCities().size() > 0) {
            deleteCity("0");
        }
        count = String.valueOf(idCount);
        idCount++;
        city.setId(count);
        this.city.save(city);

    }

    public void updateCity(City c, String id) {
        city.save(c);
    }

    public void deleteCity(String id) {
        idCount--;
        city.delete(getCity(id));
    }
}
