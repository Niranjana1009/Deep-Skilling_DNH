package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {

    private final List<Country> countryList;

    public CountryService() {

        countryList = new ArrayList<>();

        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("JP", "Japan"));
        countryList.add(new Country("DE", "Germany"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country getCountry(String code) {

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        } throw new CountryNotFoundException("Country with code " + code + " not found");
    }
}