package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    Iterable<Country> findAll();

    Page<Country> findAll(Pageable pageable);

    Iterable<Country> search(String keyword);

    Page<Country> search(String keyword, Pageable pageable);

    Country findOne(Long id);

    Country save(Country country);

    List<Country> save(List<Country> countries);

    boolean exists(Long id);

    List<Country> findAll(List<Long> ids);

    Long count();

    void delete(Long id);

    void delete(City city);

    void deleteAll();

}
