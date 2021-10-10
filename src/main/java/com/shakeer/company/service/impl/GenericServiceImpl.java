package com.shakeer.company.service.impl;

import com.shakeer.company.entity.City;
import com.shakeer.company.repository.CityRepository;
import com.shakeer.company.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private CityRepository cityRepository;


    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();


      }
}
