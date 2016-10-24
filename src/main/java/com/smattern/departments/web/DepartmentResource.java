package com.smattern.departments.web;

import com.smattern.departments.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * smattern on 29.09.16.
 */
@Controller
public class DepartmentResource {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/get-salary-for-one-department")
    @ResponseBody
    public String getSalaryForOneDepartment(String department) {

        departmentService.salaryForOneDepartment(department);

        return "The user first name is: ";
    }
}
