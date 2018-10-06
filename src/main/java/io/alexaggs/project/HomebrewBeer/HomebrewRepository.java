package io.alexaggs.project.HomebrewBeer;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository for Homebrewed beers
 */

public interface HomebrewRepository extends CrudRepository<HomebrewBeer, String> {

}