package com.codegym.service.impl;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.repository.CountryRepository;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Country> search(String keyword) {
        return null;
    }

    @Override
    public Page<Country> search(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public List<Country> save(List<Country> countries) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Country> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(City city) {

    }

    @Override
    public void deleteAll() {

    }
}
