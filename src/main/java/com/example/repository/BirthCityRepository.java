package com.example.repository;

import com.example.entity.BirthCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BirthCityRepository extends JpaRepository<BirthCity, Long>{
}
