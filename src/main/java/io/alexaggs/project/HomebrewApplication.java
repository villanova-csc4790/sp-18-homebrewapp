package io.alexaggs.project;

import io.alexaggs.project.CommercialBeer.CommercialBeer;
import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class HomebrewApplication {

	public static void main (String args[]) throws Exception {
		SpringApplication.run(HomebrewApplication.class, args);
		System.out.println();
		ArrayList<CommercialBeer> beers = CommercialBeerScraper.getTopBeersByStyle("116");
		ArrayList<String> beerInfo;
		for(int i = 0; i < 10; i++) {
			beerInfo = CommercialBeerScraper.getBeerData("https://www.beeradvocate.com" + beers.get(i).getUrl());
			beers.get(i).setCompany(beerInfo.get(0));
			beers.get(i).setAbv(beerInfo.get(1));
		}

		for(int i = 0; i < 10; i++) {
			System.out.println("Name " + beers.get(i).getName());
			System.out.println("Company " + beers.get(i).getCompany());
			System.out.println("ABV " + beers.get(i).getAbv());
			System.out.println();
		}
	}
}