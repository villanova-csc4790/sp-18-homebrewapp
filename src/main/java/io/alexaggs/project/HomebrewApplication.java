package io.alexaggs.project;

import io.alexaggs.project.CommercialBeer.CommercialBeer;
import io.alexaggs.project.CommercialBeer.CommercialBeerScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class HomebrewApplication {

	private static final String IPA_VALUE = "116";
	private static final String PILSNER_VALUE = "164";

	public static void main (String args[]) throws Exception {

		SpringApplication.run(HomebrewApplication.class, args);
//		System.out.println();
//		printTopBeers();
//		printTopIpas();
//		printTopPilsners();
	}

	public static void printTopBeers() throws Exception {
		System.out.println("------------TOP OVERALL BEERS------------");

		ArrayList<CommercialBeer> topBeers = CommercialBeerScraper.getTopBeers();
		ArrayList<String> beerInfo;
		for(int i = 0; i < 10; i++) {
			beerInfo = CommercialBeerScraper.getBeerData("https://www.beeradvocate.com" + topBeers.get(i).getUrl());
			topBeers.get(i).setCompany(beerInfo.get(0));
			topBeers.get(i).setAbv(beerInfo.get(1));
		}

		for(int i = 0; i < 10; i++) {
			System.out.println("Name: " + topBeers.get(i).getName());
			System.out.println("Company: " + topBeers.get(i).getCompany());
			System.out.println("ABV: " + topBeers.get(i).getAbv());
			System.out.println();
		}
	}

	public static void printTopIpas() throws Exception {
		System.out.println("------------TOP IPAS------------");
		ArrayList<CommercialBeer> topIpas = CommercialBeerScraper.getTopBeers(IPA_VALUE);
		ArrayList<String> ipaInfo;
		for(int i = 0; i < 10; i++) {
			ipaInfo = CommercialBeerScraper.getBeerData("https://www.beeradvocate.com" + topIpas.get(i).getUrl());
			topIpas.get(i).setCompany(ipaInfo.get(0));
			topIpas.get(i).setAbv(ipaInfo.get(1));
		}

		for(int i = 0; i < 10; i++) {
			System.out.println("Name: " + topIpas.get(i).getName());
			System.out.println("Company: " + topIpas.get(i).getCompany());
			System.out.println("ABV: " + topIpas.get(i).getAbv());
			System.out.println();
		}
	}

	public static void printTopPilsners() throws Exception {
		System.out.println("------------TOP PILSNERS------------");
		ArrayList<CommercialBeer> topPilsners = CommercialBeerScraper.getTopBeers(PILSNER_VALUE);
		ArrayList<String> pilsnerInfo;
		for(int i = 0; i < 10; i++) {
			pilsnerInfo = CommercialBeerScraper.getBeerData("https://www.beeradvocate.com" + topPilsners.get(i).getUrl());
			topPilsners.get(i).setCompany(pilsnerInfo.get(0));
			topPilsners.get(i).setAbv(pilsnerInfo.get(1));
		}

		for(int i = 0; i < 10; i++) {
			System.out.println("Name: " + topPilsners.get(i).getName());
			System.out.println("Company: " + topPilsners.get(i).getCompany());
			System.out.println("ABV: " + topPilsners.get(i).getAbv());
			System.out.println();
		}
	}
}