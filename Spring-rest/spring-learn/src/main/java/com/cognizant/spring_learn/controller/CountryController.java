package com.cognizant.spring_learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        Country country = new Country("IN", "India");

        LOGGER.info("END");

        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("Fetching all countries");

        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{code}")
public Country getCountry(@PathVariable String code) {

    LOGGER.info("Fetching country {}", code);

    return countryService.getCountry(code);
}

}
