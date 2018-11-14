package io.alexaggs.project.BeerAlert;

import io.alexaggs.project.BeerAlert.City;
import org.springframework.data.repository.CrudRepository;

/*
 * Repository for Breweries
 */

public interface CityRepo extends CrudRepository<City, String> {

}