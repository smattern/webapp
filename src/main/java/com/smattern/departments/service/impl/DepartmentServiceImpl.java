package com.smattern.departments.service.impl;

import com.smattern.departments.repository.DepartmentRepository;
import com.smattern.departments.service.DepartmentService;
import com.smattern.domain.Departments;
import com.smattern.domain.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * smattern on 29.09.16.
 */
@Service
class DepartmentServiceImpl implements DepartmentService{

    // Logger
    private final static Logger LOGGER = Logger.getLogger(DepartmentServiceImpl.class.getSimpleName());

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public long salaryForOneDepartment(String department) {

        Departments departments = departmentRepository.findByDepartmantName(department);

        List<Employees> resultset = departments.getEmployees();

        for (Employees employees : resultset) {
            LOGGER.info(String.valueOf(employees.getId()));
        }

        return 0;
    }
}
