package io.alexaggs.project;

import io.alexaggs.project.BeerAlert.BeerMailService;
import io.alexaggs.project.BeerAlert.NearbyBreweries;
import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class HomebrewApplication {

	private static final String IPA_VALUE = "116";
	private static final String PILSNER_VALUE = "164";

	public static void main (String args[]) throws Exception {

		SpringApplication.run(HomebrewApplication.class, args);
	}
}