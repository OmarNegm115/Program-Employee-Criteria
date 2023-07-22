package com.example.service;

import com.example.entity.BirthCity;
import com.example.entity.Department;
import com.example.repository.BirthCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthCityService {
    @Autowired
    BirthCityRepository birthCityRepository;

    public BirthCity createBirthCity(BirthCity birthCity ){
        birthCityRepository.save(birthCity);
        return birthCity;
    }

    public List<BirthCity> fetchAllBirthCity() {

        return birthCityRepository.findAll();
    }
}
