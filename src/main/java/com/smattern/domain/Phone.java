package com.smattern.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * smattern on 20/10/16.
 */
@Entity
public class Phone {

    @Id
    private int id;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
