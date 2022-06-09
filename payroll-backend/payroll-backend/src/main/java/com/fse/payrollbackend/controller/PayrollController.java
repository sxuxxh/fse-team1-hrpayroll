package com.fse.payrollbackend.controller;
import com.fse.payrollbackend.service.IPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    FSE Cohort - Team Project 3
    HR Payroll System - Team 1
    Class: PayrollController - Controller methods for PayrollServiceIMPL
 */

@CrossOrigin   (origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/hrpayroll/api/v1")
public class PayrollController {
    private final IPayrollService payrollService;

    //Constructor Injection
    @Autowired
    public PayrollController(@Qualifier("PayrollServiceIMPL") IPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    //Get read all request
    //http://localhost:8080/hrpayroll/api/v1/retrieveAllEmployees
    @GetMapping("retrieveAllEmployees")
    public List<Employee> findAll(){
        return payrollService.findAll();
    }

    //read a Employee request
    //http://localhost:8080/hrpayroll/api/v1/reatrieveAEmployee/1
    @GetMapping("retrieveAEmployee/{employeeID}")
    public Employee findByID(@PathVariable int employeeID) {
        return payrollService.findByID(employeeID);
    }

    //This is a POST request to add an Employee
    //http://localhost:8080/hrpayroll/api/v1/addAEmployee
    @PostMapping("/addAEmployee")
    public Employee addAEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setEmployeeID(0);
        payrollService.saveOrUpdate(theEmployee);
        return theEmployee;
    }

    //This is a PUT request to update an existing employee
    //http://localhost:8080/hrpayroll/api/v1/updateAEmployee
    @PutMapping("/updateAEmployee")
    public Employee updateAEmployee(@RequestBody Employee updateAEmployee) {
        payrollService.saveOrUpdate(updateAEmployee);
        return updateAEmployee;
    }
    //This is a DELETE request to update an existing employee
    //http://localhost:8080/hrpayroll/api/v1/deleteAEmployee/1
    @DeleteMapping("/deleteAEmployee/{employeeID}")
    public String deleteAEmployee(@PathVariable int employeeID) {
        payrollService.deleteById(employeeID);
        return "Deleted Employee ID: " + employeeID;
    }
}
