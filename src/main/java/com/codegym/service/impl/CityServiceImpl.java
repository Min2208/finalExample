package com.codegym.service.impl;

import com.codegym.model.City;
import com.codegym.repository.CityRepository;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Iterable<City> search(String keyword) {
        return cityRepository.findAllByNameContains(keyword);
    }

    @Override
    public Page<City> search(String keyword, Pageable pageable) {
        return cityRepository.findAllByNameContains(keyword,pageable);
    }

    @Override
    public City findOne(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> save(List<City> cities) {
        return (List<City>) cityRepository.saveAll(cities);
    }

    @Override
    public boolean exists(Long id) {
        return cityRepository.existsById(id);
    }

    @Override
    public List<City> findAll(List<Long> ids) {
        return (List<City>) cityRepository.findAllById(ids);
    }

    @Override
    public Long count() {
        return cityRepository.count();
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }
}
