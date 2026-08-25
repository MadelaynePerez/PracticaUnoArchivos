/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * @author Ana
 */
public class Appointment {
    String id;
    int inePaciente;
    String UUIdDoctor;
    LocalDate date; 
    LocalTime startHour;
    String reason;
    String status = "programada";
    String observation;
    boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInePaciente() {
        return inePaciente;
    }

    public void setInePaciente(int inePaciente) {
        this.inePaciente = inePaciente;
    }

    public String getUUIdDoctor() {
        return UUIdDoctor;
    }

    public void setUUIdDoctor(String UUIdMedico) {
        this.UUIdDoctor = UUIdMedico;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Appointment() {
    }

    public Appointment(String id, int inePaciente, String UUIdDoctor, LocalDate date, LocalTime startHour, String reason, String observation) {
        this.id = id;
        this.inePaciente = inePaciente;
        this.UUIdDoctor = UUIdDoctor;
        this.date = date;
        this.startHour = startHour;
        this.reason = reason;
        this.observation = observation;
    }

    
            
    
}
