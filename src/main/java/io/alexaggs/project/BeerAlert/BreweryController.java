package io.alexaggs.project.BeerAlert;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.model.PlacesSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BreweryController {

    @Autowired
    private io.alexaggs.project.Brewery.BreweryService cbService;

    @RequestMapping("/Breweries")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Brewery> getAllBeers() {
        return cbService.getAllBeers();
    }

    @RequestMapping("/Breweries/{id}")
    public Brewery getBeer(@PathVariable String id) {
        System.out.println("GET");
        return cbService.getBrewery(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/Breweries")
    public void addBeer(@RequestBody Brewery b) throws Exception {
        PlacesSearchResult[] places = NearbyBreweries.findPlaces();
        for(PlacesSearchResult p: places) {
            b.setName(p.name);
            cbService.addBrewery(b);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value="/Breweries/{id}")
    public void updateBeer(@RequestBody Brewery beer, @PathVariable String id) {
        System.out.println("Put");
        cbService.updateBrewery(beer, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/Breweries/{id}")
    public void deleteBeer(@PathVariable String id) {
        System.out.println("Delete");
        cbService.deleteBrewery(id);
    }
}
