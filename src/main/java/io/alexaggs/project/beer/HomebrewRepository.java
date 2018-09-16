package io.alexaggs.project.beer;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository for Homebrewed beers
 */

public interface HomebrewRepository extends CrudRepository<HomebrewBeer, String> {

}