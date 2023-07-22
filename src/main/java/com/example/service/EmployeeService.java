package com.example.service;


import com.example.dto.EmployeeDto;
import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        EmployeeEntity employeeEntity = convertToEntity(employeeDto);

        EmployeeEntity newEmployeeEntity = employeeRepository.save(employeeEntity);

        EmployeeDto newEmployeeDto = convertToDto(newEmployeeEntity);

        return newEmployeeDto;

    }

    //A method to fetch all data from table employee
    public List<EmployeeDto> getAllEmployees(){

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        //Streaming the list of returned entities to convert them to Dtos
        List<EmployeeDto> employeeDtos = employeeEntities.stream().map(employeeEntity -> convertToDto(employeeEntity)).collect(Collectors.toList());

        return employeeDtos;
    }




    public EmployeeDto convertToDto(EmployeeEntity employeeEntity){

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeCode(employeeEntity.getEmployeeCode());
        employeeDto.setEmployeeName(employeeEntity.getEmployeeName());
        employeeDto.setEmployeeBirthDate(employeeEntity.getEmployeeBirthDate());
        employeeDto.setBirthCity(employeeEntity.getBirthCity());
        employeeDto.setJobTitle(employeeEntity.getJobTitle());
        employeeDto.setDepartment(employeeEntity.getDepartment());
        employeeDto.setContractType(employeeEntity.getContractType());
        employeeDto.setDirectManager(employeeEntity.getDirectManager());
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setIsActive(employeeEntity.getIsActive());

        return employeeDto;
    }

    public EmployeeEntity convertToEntity(EmployeeDto employeeDto){

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmployeeCode(employeeDto.getEmployeeCode());
        employeeEntity.setEmployeeName(employeeDto.getEmployeeName());
        employeeEntity.setEmployeeBirthDate(employeeDto.getEmployeeBirthDate());
        employeeEntity.setJobTitle(employeeDto.getJobTitle());
        employeeEntity.setBirthCity(employeeDto.getBirthCity());
        employeeEntity.setDepartment(employeeDto.getDepartment());
        employeeEntity.setContractType(employeeDto.getContractType());
        employeeEntity.setDirectManager(employeeDto.getDirectManager());
        employeeEntity.setIsActive(employeeDto.getIsActive());

        return employeeEntity;
    }

    public List<EmployeeEntity> searchEmployee(Long dID, String jT, String dM, Long cTID, Integer eCode, String eName, LocalDate eBD, Boolean sT, Long bcID) {
        return employeeRepository.searchEmpEntity(dID, jT, dM, cTID, eCode, eName, eBD, sT, bcID);
    }
}