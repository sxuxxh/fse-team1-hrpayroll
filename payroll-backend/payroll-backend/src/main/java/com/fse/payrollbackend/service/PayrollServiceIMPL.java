/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: IPayrollService - payroll service implementation
 */
package com.fse.payrollbackend.service;

import com.fse.payrollbackend.dao.IPayrollDAO;
import com.fse.payrollbackend.entity.Employee;
import com.fse.payrollbackend.exception.EmployeeNotFoundForDeleteException;
import com.fse.payrollbackend.exception.EmployeeNotFoundForGetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class PayrollServiceIMPL implements IPayrollService{
    // Injecting the computer part dao layer
    private final IPayrollDAO payrollDAO;

    @Autowired
    public PayrollServiceIMPL(@Qualifier("payrollDAOIMPL") IPayrollDAO payrollDAO) {
        this.payrollDAO = payrollDAO;
    }

    @Override
    public List<Employee> findAll() {
        return payrollDAO.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        if (payrollDAO.findById(employeeId) == null) {
            throw new EmployeeNotFoundForGetException(employeeId);
        } else {
            return payrollDAO.findById(employeeId);
        }
    }

    @Override
    public void saveOrUpdate(Employee theEmployee) {
        payrollDAO.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int employeeId) {
        if (payrollDAO.findById(employeeId) == null) {
            throw new EmployeeNotFoundForDeleteException(employeeId);
        } else {
            payrollDAO.deleteById(employeeId);
        }
    }
}
