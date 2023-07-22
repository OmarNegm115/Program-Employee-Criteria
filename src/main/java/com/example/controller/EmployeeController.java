package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.entity.EmployeeEntity;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }
    @GetMapping("/searchEmployee")
    public  List<EmployeeEntity> searchEmployee(@RequestParam(required = false) Long dID,
                                                @RequestParam(required = false) String jT,
                                                @RequestParam(required = false) String dM,
                                                @RequestParam(required = false) Long cTID,
                                                @RequestParam(required = false) Integer eCode,
                                                @RequestParam(required = false) String eName,
                                                @RequestParam(required = false) String eBD,
                                                @RequestParam(required = false) Boolean sT,
                                                @RequestParam(required = false) Long bcID) throws ParseException {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate employeeBirthDate = null;
        if(null != eBD && !eBD.isEmpty()){
            employeeBirthDate = LocalDate.parse(eBD, inputFormat);
        }
        return employeeService.searchEmployee(dID, jT, dM, cTID, eCode, eName, employeeBirthDate, sT, bcID);
    }
    @GetMapping("/all-employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
