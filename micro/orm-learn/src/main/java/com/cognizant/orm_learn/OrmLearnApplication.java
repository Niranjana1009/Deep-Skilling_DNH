package com.cognizant.orm_learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.orm_learn.model.Country;

import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private final CountryService service;

    public OrmLearnApplication(CountryService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
	public void run(String... args) {

	    Country country = new Country("FR", "France");

	    service.addCountry(country);

	    System.out.println(service.findCountryByCode("FR"));
}
}
