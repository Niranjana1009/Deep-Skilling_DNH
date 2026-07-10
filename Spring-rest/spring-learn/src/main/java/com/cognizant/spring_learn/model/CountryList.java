package com.cognizant.spring_learn.model;

import java.util.List;

public class CountryList {

    private List<Country> countryList;

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String toString() {
        return countryList.toString();
    }
}