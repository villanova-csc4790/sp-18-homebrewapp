package io.alexaggs.project;

import io.alexaggs.project.CommercialBeer.CommercialBeer;
import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class HomebrewApplication {

	public static void main (String args[]) throws Exception {
		//SpringApplication.run(HomebrewApplication.class, args);
		ArrayList<CommercialBeer> beers = CommercialBeerScraper.getTopBeers();

		for(CommercialBeer b: beers) {
			System.out.println(CommercialBeerScraper.getBeerData(
					"https://www.beeradvocate.com" + b.getUrl()));
		}
	}
}
