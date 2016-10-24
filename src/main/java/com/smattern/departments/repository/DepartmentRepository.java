package com.smattern.departments.repository;

import com.smattern.domain.Departments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * smattern on 29.09.16.
 */
@Transactional
public interface DepartmentRepository extends CrudRepository<Departments, Integer> {

    Departments findByDepartmantName(String department);
}
