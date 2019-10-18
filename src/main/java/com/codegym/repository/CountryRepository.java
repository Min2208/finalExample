package com.codegym.repository;

import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    Iterable<Country> findAllByNameContains(String firstNumber);

    Page<Country> findAllByNameContains(String firstName, Pageable pageable);
}
