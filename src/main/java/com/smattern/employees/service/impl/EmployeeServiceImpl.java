package com.smattern.employees.service.impl;

import com.google.common.collect.Lists;
import com.smattern.domain.Employees;
import com.smattern.employees.repository.EmployeesRepository;
import com.smattern.employees.service.EmployeeService;
import com.smattern.employees.web.dto.EmployeeDTO;
import com.smattern.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * smattern on 29.09.16.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees getEmployeesByFirstAndLastName(String firstname, String lastname) {
        return employeesRepository.findByFirstnameAndLastname(firstname, lastname);
    }

    @Override
    public Employees getEmployeesByID(int id) {
        return employeesRepository.findById(id);
    }

    @Override
    public ArrayList<Employees> getAllEmployees() {
        Iterator<Employees> iteratorToArray = employeesRepository.findAll().iterator();
        return Lists.newArrayList(iteratorToArray);
    }

    @Override
    public Employees findById(int id) {
        return employeesRepository.findById(id);
    }

    @Override
    public Employees persist(EmployeeDTO input) {

        Employees emp = new Employees();
        emp.setId(12345);
        emp.setBirthDate(new Date());
        emp.setHireDate(new Date());
        emp.setFirstname(input.getFirstname());// mapping first name
        emp.setLastname(input.getLastname());// mapping last name

        switch (input.getGender()){
            case "M":
                emp.setGender(Gender.M);
                break;
            case "F":
                emp.setGender(Gender.F);
        }// mapping gender

        employeesRepository.save(emp);

        return emp;
    }

}
