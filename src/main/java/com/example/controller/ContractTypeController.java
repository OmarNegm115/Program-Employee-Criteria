package com.example.controller;

import com.example.entity.ContractType;
import com.example.entity.Department;
import com.example.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")

public class ContractTypeController {
    @Autowired
    ContractTypeService contractTypeService;


    @GetMapping()
    public List<ContractType> fetchAllContracts(){
        return contractTypeService.fetchAllContractType();
    }
}
