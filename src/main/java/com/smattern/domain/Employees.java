package com.smattern.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smattern.util.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author smattern
 */
@Entity
@Table(name = "employees")
public class Employees {

    private int id;
    private java.lang.String lastname;
    private java.lang.String firstname;
    private Date birthDate;
    private Date hireDate;
    private Gender gender;
    private List<Departments> departments = new ArrayList<Departments>();

    public Employees() {
    }

    public Employees(int id, java.lang.String lastname, java.lang.String firstname, Date birthDate, Date hireDate,
                     Gender gender, List<Departments> departments) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.gender = gender;
        this.departments = departments;
    }

    @Id
    @Column(name = "emp_no")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public java.lang.String getLastname() {
        return lastname;
    }

    public void setLastname(java.lang.String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "first_name")
    public java.lang.String getFirstname() {
        return firstname;
    }

    public void setFirstname(java.lang.String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "dept_emp", joinColumns = @JoinColumn(name = "emp_no"),
            inverseJoinColumns = @JoinColumn(name = "dept_no"))
    @JsonManagedReference
    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", gender=" + gender +
                ", departments=" + departments +
                '}';
    }
}
