/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServicePatients;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Patient;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class SearchPatient extends FileUtil {

    private final ListPatients listPatients = new ListPatients();

    public ArrayList<Patient> searchPatient(String search) {

        ArrayList<Patient> resultados = new ArrayList<>();

        search = search.trim().toLowerCase();

        for (Patient patient : listPatients.listPatients()) {

            String ine = String.valueOf(patient.getIne());
            String nombre = patient.getFullName().trim().toLowerCase();

            if (ine.equals(search)
                    || nombre.contains(search)) {

                resultados.add(patient);
            }
        }

        return resultados;
    }
}
