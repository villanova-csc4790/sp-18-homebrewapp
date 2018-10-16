package io.alexaggs.project.CommercialBeer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommercialBeerController {

    @Autowired
    CommercialBeerRepository repository;


}
