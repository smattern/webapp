package com.smattern.employees.web;

import com.smattern.domain.Employees;
import com.smattern.employees.service.EmployeeService;
import com.smattern.employees.web.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author smattern
 */
@Controller
class EmployeeResource {

    // Logger
    private final static Logger LOGGER = Logger.getLogger(EmployeeResource.class.getSimpleName());

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get Employee by id.
     * <p>
     *
     * @param id, employee id
     * @return employee object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Employees> getEmployeeByID(@PathVariable("id") int id) {
        LOGGER.info("Fetching Employees with id " + id);
        Employees user = employeeService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employees>(user, HttpStatus.OK);
    }

    /**
     * Insert a new employee.
     * <p>
     *
     * @param input, input object
     * @return the new employee object
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Employees> update(@RequestBody EmployeeDTO input) {
        LOGGER.log(Level.INFO, "Add a new Employee: " + input.toString());
        Employees emp = employeeService.persist(input);
        return new ResponseEntity<Employees>(emp, HttpStatus.OK);
    }

    /**
     * Get all employees.
     * <p>
     *
     * @return employee object
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Employees>> getAllEmployees() {
        LOGGER.info("Get all Employees");
        ArrayList<Employees> employees = employeeService.getAllEmployees();

        if(employees.isEmpty()){
            return new ResponseEntity<ArrayList<Employees>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ArrayList<Employees>>(employees, HttpStatus.OK);
    }
}
