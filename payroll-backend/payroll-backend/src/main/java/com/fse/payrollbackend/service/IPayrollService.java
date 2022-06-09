/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: IPayrollService - payroll service interface
 */
package com.fse.payrollbackend.service;
import com.fse.payrollbackend.entity.Employee;

import java.util.List;

public interface IPayrollService {
    List<Employee> findAll();
    Employee findById(int employeeId);
    void saveOrUpdate(Employee theEmployee);
    void deleteById(int employeeId);

    Employee findByID(int employeeID);
}
