package com.smattern.employees.service;

import com.smattern.domain.Employees;
import com.smattern.employees.web.dto.EmployeeDTO;

import java.util.ArrayList;

/**
 * @author smattern on 29.09.16.
 */
public interface EmployeeService {

    /**
     * Get Employee by first and last name.
     *
     * @param firstname, the first name
     * @param lastname, the last name
     * @return the result set
     */
    Employees getEmployeesByFirstAndLastName(String firstname, String lastname);

    /**
     * Get employee by id.
     *
     * @param id, employee id
     * @return the employee
     */
    Employees getEmployeesByID(int id);

    /**
     * Get all employees.
     *
     * @return List of all employees
     */
    ArrayList<Employees> getAllEmployees();

    /**
     * Fetching employee by id.
     *
     * @param id the identifier
     * @return the employee
     */
    Employees findById(int id);

    /**
     *
     * @param input
     * @return
     */
    Employees persist(EmployeeDTO input);
}
