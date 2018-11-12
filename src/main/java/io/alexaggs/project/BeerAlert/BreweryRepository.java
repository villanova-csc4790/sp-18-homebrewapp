package io.alexaggs.project.BeerAlert;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository for Breweries
 */

public interface BreweryRepository extends CrudRepository<Brewery, String> {

}