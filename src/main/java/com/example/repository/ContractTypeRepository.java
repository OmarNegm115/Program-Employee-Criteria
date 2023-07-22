package com.example.repository;

import com.example.entity.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Long>{
}
