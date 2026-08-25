/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServiceAppointment;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class SearchAppointment extends FileUtil {

    private final ListAppointment listAppointment = new ListAppointment();

    public Appointment searchById(String id) {

        ArrayList<Appointment> list = listAppointment.listAppointments();

        for (Appointment appointment : list) {

            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }

        return null;
    }

    public ArrayList<Appointment> searchByPatient(int inePaciente) {

        ArrayList<Appointment> result = new ArrayList<>();
        ArrayList<Appointment> list = listAppointment.listAppointments();

        for (Appointment appointment : list) {

            if (appointment.getInePaciente() == inePaciente) {
                result.add(appointment);
            }
        }

        return result;
    }

    public ArrayList<Appointment> searchByDoctor(String uuidDoctor) {

        ArrayList<Appointment> result = new ArrayList<>();
        ArrayList<Appointment> list = listAppointment.listAppointments();

        for (Appointment appointment : list) {

            if (appointment.getUUIdDoctor().equals(uuidDoctor)) {
                result.add(appointment);
            }
        }

        return result;
    }

    public ArrayList<Appointment> searchByDate(LocalDate date) {

        ArrayList<Appointment> result = new ArrayList<>();
        ArrayList<Appointment> list = listAppointment.listAppointments();

        for (Appointment appointment : list) {

            if (appointment.getDate().equals(date)) {
                result.add(appointment);
            }
        }

        return result;
    }

    public ArrayList<Appointment> searchByStatus(String status) {

        ArrayList<Appointment> result = new ArrayList<>();
        ArrayList<Appointment> list = listAppointment.listAppointments();

        for (Appointment appointment : list) {

            if (appointment.isStatus().equalsIgnoreCase(status)) {
                result.add(appointment);
            }
        }

        return result;
    }
}
