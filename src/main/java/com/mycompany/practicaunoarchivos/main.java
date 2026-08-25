/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos;

import Vistas.General;
import com.mycompany.practicaunoarchivos.DoctorService.CreateDoctor;
import com.mycompany.practicaunoarchivos.DoctorService.ListDoctors;
import com.mycompany.practicaunoarchivos.DoctorService.SearchDoctor;
import com.mycompany.practicaunoarchivos.Models.Appointment;
import com.mycompany.practicaunoarchivos.Models.Doctor;
import com.mycompany.practicaunoarchivos.Models.Patient;
import com.mycompany.practicaunoarchivos.ServiceAppointment.CreateAppointment;
import com.mycompany.practicaunoarchivos.ServicePatients.CreatePatient;
import com.mycompany.practicaunoarchivos.ServicePatients.DeletePatient;
import com.mycompany.practicaunoarchivos.ServicePatients.ListPatients;
import com.mycompany.practicaunoarchivos.ServicePatients.UpdatePatient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class main {

    public static void main(String[] args) {

        /*  ListDoctors lista = new ListDoctors();

        for (Doctor doctor : lista.listDoctors()) {
            System.out.println("ID: " + doctor.getId());
            System.out.println("Nombre: " + doctor.getFullName());
            System.out.println("Especialidad: " + doctor.getSpecialty());
            System.out.println("Activo: " + doctor.isActive());
            System.out.println("----------------------");
        }*/
        General vista = new General();
        vista.setVisible(true);
        /*SearchDoctor buscar = new SearchDoctor();

        ArrayList<Doctor> resultados = buscar.searchDoctor("Ana");

        for (Doctor doctor : resultados) {
            System.out.println("ID: " + doctor.getId());
            System.out.println("Nombre: " + doctor.getFullName());
            System.out.println("Especialidad: " + doctor.getSpecialty());
        }*/
    }

}
