package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.exception.CountryNotFoundException;
@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) {

    return repository.findById(code).orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    @Transactional
    public void addCountry(Country country) {
        repository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        Country country = repository.findById(code).orElseThrow(() -> new CountryNotFoundException("Country not found"));
        country.setName(name);
        repository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }
}