package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "employee", schema = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "employee_code", nullable = true)
    private Integer employeeCode;

    @Column(name = "employee_name", nullable = true, length = 60)
    private String employeeName;

    @Column(name = "employee_birth_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthDate;

    @Column(name = "job_title", nullable = true, length = 45)
    private String jobTitle;

    @Column(name = "direct_manager", nullable = true, length = 45)
    private String directManager;

    @Column(name = "status", nullable = false)
    private Boolean isActive;

    @ManyToOne
    private Department department;

    @ManyToOne
    private ContractType contractType;

    @ManyToOne
    private BirthCity birthCity;
}


