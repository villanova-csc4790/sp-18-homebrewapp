package io.alexaggs.project.CommercialBeer;

import java.util.ArrayList;
import java.util.List;

import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommercialBeerController {

    @Autowired
    private CommercialBeerService cbService;

    @RequestMapping("/Commercials")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<CommercialBeer> getAllBeers() {
        return cbService.getAllBeers();
    }

    @RequestMapping("/Commercials/{id}")
    public CommercialBeer getBeer(@PathVariable String id) {
        System.out.println("GET");
        return cbService.getBeer(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/Commercials")
    public void addBeer(@RequestBody CommercialBeer beer) throws Exception {
        System.out.println("POST");
        ArrayList<CommercialBeer> topBeers = CommercialBeerScraper.getTopBeers();
        for(int i = 0; i < 10; i++) {
            cbService.addBeer(topBeers.get(i));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value="/Commercials/{id}")
    public void updateBeer(@RequestBody CommercialBeer beer, @PathVariable String id) {
        System.out.println("Put");
        cbService.updateBeer(beer, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/Commercials/{id}")
    public void deleteBeer(@PathVariable String id) {
        System.out.println("Delete");
        cbService.deleteBeer(id);
    }
}
