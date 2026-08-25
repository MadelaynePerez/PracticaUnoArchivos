/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.DoctorService;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class SearchDoctor extends FileUtil {
     private final ListDoctors listDoctors = new ListDoctors();

    public ArrayList<Doctor> searchDoctor(String search) {

        ArrayList<Doctor> results = new ArrayList<>();
        search = search.trim().toLowerCase();

        for (Doctor doctor : listDoctors.listDoctors()) {

            String id = doctor.getId().trim().toLowerCase();
            String name = doctor.getFullName().trim().toLowerCase();
            String specialty = doctor.getSpecialty().trim().toLowerCase();

            if (id.equals(search)
                    || name.contains(search)
                    || specialty.contains(search)) {

                results.add(doctor);
            }
        }

        return results;
    }
}
