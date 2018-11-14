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
    BreweryService brewService;

    @RequestMapping("/Breweries")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Brewery> getAllBeers() {
        return brewService.getAllBeers();
    }

    @RequestMapping("/Breweries/{id}")
    public Brewery getBeer(@PathVariable String id) {
        System.out.println("GET");
        return brewService.getBrewery(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/Breweries")
    public void addBeer(@RequestBody Brewery b) throws Exception {
        PlacesSearchResult[] places = NearbyBreweries.findPlaces("Villanova");
        List<Brewery> brew = getAllBeers();
        List<String> names = new ArrayList<String>();
        for(Brewery br: brew) {
            names.add(br.getName());
        }
        for(PlacesSearchResult p: places) {
            if(!names.contains(p.name)) {
                b.setName(p.name);
                b.setLatLng(p.geometry.location);
                brewService.addBrewery(b);
            }
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value="/Breweries/{id}")
    public void updateBeer(@RequestBody Brewery beer, @PathVariable String id) {
        System.out.println("Put");
        brewService.updateBrewery(beer, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/Breweries/{id}")
    public void deleteBeer(@PathVariable String id) {
        System.out.println("Delete");
        brewService.deleteBrewery(id);
    }
}
