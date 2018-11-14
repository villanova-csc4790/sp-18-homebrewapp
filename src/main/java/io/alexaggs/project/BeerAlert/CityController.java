package io.alexaggs.project.BeerAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    public static String n;
    public static double r;

    @Autowired
    CityService cService;

    @RequestMapping("/City")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<City> getAllBeers() {
        return cService.getAllCities();
    }

    @RequestMapping("/City/{id}")
    public City getBeer(@PathVariable String id) {
        System.out.println("GET");
        return cService.getCity(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/City")
    @CrossOrigin(origins = "http://localhost:3000")
    public void getCity(@RequestBody City c) {
        n = c.getName();
        r = c.getRadius();
        cService.addCity(c);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/City/{id}")
    public void updateCity(@RequestBody City c, @PathVariable String id) {
        System.out.println("Put");
        cService.updateCity(c, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/City/{id}")
    public void deleteCity(@PathVariable String id) {
        System.out.println("Delete");
        cService.deleteCity(id);
    }
}
