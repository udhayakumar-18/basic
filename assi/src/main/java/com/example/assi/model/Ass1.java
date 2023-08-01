package com.example.assi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "get_details")



public class Ass1 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Firstname")
    private String firstname;
    
    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "City")
    private String city;

    public Ass1() {
    }

    public Ass1(Long id, String firstname, String lastname, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Get [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + "]";
    }







}
