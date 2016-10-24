package com.smattern.employees.repository;

import com.smattern.domain.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author smattern
 */
@Transactional
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {

    Employees findByFirstnameAndLastname(String firstname, String lastname);

    Employees findById(int id);
}
