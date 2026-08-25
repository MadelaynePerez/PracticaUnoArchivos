/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.Models;

import java.time.LocalTime;
import java.util.UUID;



/**
 *
 * @author Ana
 */
public class Doctor {
    
    String id;
    String fullName;
    String specialty;
    String phoneNumber ;
    String email;
    LocalTime startHour;
    LocalTime endHour;
    boolean active = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Doctor() {
    }

    public Doctor( String fullName, String specialty, String phoneNumber, String email, LocalTime startHour, LocalTime endHour) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    

}

