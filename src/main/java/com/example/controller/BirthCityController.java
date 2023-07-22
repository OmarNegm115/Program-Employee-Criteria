package com.example.controller;

import com.example.entity.BirthCity;
import com.example.entity.Department;
import com.example.service.BirthCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birthcity")
public class BirthCityController {
    @Autowired
    BirthCityService birthCityService;

    @PostMapping("/createBirthCity")
    public BirthCity createBirthCity(@RequestBody BirthCity birthCity) {
        return birthCityService.createBirthCity(birthCity);
    }

    @GetMapping()
    public List<BirthCity> fetchAllBirthCities(){
        return birthCityService.fetchAllBirthCity();
    }
}
