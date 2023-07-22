package com.example.dto;

import com.example.entity.BirthCity;
import com.example.entity.ContractType;
import com.example.entity.Department;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int id;

    private Integer employeeCode;

    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthDate;

    private String jobTitle;

    private String directManager;

    private Department department;

    private BirthCity birthCity;

    private ContractType contractType;

    private Boolean isActive;
    
}

