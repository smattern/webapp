package com.smattern.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author smattern
 */
@Entity
@Table(name = "departments")
public class Departments {

    private int id;
    private String departmantName;
    private List<Employees> employees = new ArrayList<>();

    public Departments() {
    }

    public Departments(int id, String departmantName, List<Employees> employees) {
        this.id = id;
        this.departmantName = departmantName;
        this.employees = employees;
    }

    @Id
    @Column(name = "dept_no")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "dept_name")
    public String getDepartmantName() {
        return departmantName;
    }

    public void setDepartmantName(String departmantName) {
        this.departmantName = departmantName;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="departments")
    @JsonBackReference
    public List<Employees> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employees> employees)
    {
        this.employees = employees;
    }
}
