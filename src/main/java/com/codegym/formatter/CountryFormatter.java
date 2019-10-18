package com.codegym.formatter;


import com.codegym.model.Country;
import com.codegym.service.CountryService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter<Country> {
    private CountryService countryService;

    public CountryFormatter(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findOne(Long.valueOf(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return object.toString();
    }


}
