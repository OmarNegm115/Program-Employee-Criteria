package com.example.service;
import com.example.entity.ContractType;
import com.example.entity.Department;
import com.example.repository.ContractTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeService {
    @Autowired
    ContractTypeRepository contractTypeRepository;

    public List<ContractType> fetchAllContractType() {
        return contractTypeRepository.findAll();
    }
}
