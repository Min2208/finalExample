package com.codegym.service;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    List<City> findAll();

    Page<City> findAll(Pageable pageable);

    Iterable<City> search(String keyword);

    Page<City> search(String keyword, Pageable pageable);

    City findOne(Long id);

    City save(City city);

    List<City> save(List<City> cities);

    boolean exists(Long id);

    List<City> findAll(List<Long> ids);

    Long count();

    void delete(Long id);

    void delete(City city);

    void deleteAll();

}
