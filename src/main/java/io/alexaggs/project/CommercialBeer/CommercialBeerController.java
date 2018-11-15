package io.alexaggs.project.CommercialBeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.alexaggs.project.BeerAlert.BeerMailService;
import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommercialBeerController {

    @Autowired
    private CommercialBeerService cbService;

    private HashMap<String, String> styles = CommercialBeerScraper.populate();

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
        String beerNames = "";
        deleteBeers();
        System.out.println(styles.get(beer.getStyle()));
        ArrayList<CommercialBeer> topBeers = new ArrayList<CommercialBeer>();
        if(beer.getStyle().equalsIgnoreCase("General")) {
            topBeers = CommercialBeerScraper.getTopBeers();
        }
        else {
            topBeers = CommercialBeerScraper.getTopBeers(styles.get(beer.getStyle()));
        }
        ArrayList<String> beerInfo;
        for(int i = 0; i < 10; i++) {
            beerInfo = CommercialBeerScraper.getBeerData("https://www.beeradvocate.com" + topBeers.get(i).getUrl());
            beerNames += topBeers.get(i).getName() + "\n";
            topBeers.get(i).setCompany(beerInfo.get(0));
            topBeers.get(i).setAbv(beerInfo.get(1));
            cbService.addBeer(topBeers.get(i));
        }

        BeerMailService.sendBeers(beerNames, beer.getStyle());
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

    public void deleteBeers() {
        for(CommercialBeer b: getAllBeers()) {
            deleteBeer(b.getId());
        }
    }
}
