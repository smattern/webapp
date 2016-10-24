package com.smattern.employees.web.dto;

/**
 * smattern on 20/10/16.
 */
public class EmployeeDTO {

    private String firstname;
    private String lastname;
    private String gender;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
