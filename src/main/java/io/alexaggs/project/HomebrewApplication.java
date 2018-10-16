package io.alexaggs.project;

import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HomebrewApplication {

	public static void main (String args[]) throws Exception {
		//SpringApplication.run(HomebrewApplication.class, args);
		System.out.println(CommercialBeerScraper.getData());
	}
}
