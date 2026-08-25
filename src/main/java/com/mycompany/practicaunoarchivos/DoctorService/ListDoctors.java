/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.DoctorService;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Doctor;
import java.io.RandomAccessFile;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class ListDoctors extends FileUtil {

    private static final int ID_LENGTH = 36;
    private static final int NAME_LENGTH = 50;
    private static final int SPECIALTY_LENGTH = 50;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50;
    private static final int START_HOUR_LENGTH = 6;
    private static final int END_HOUR_LENGTH = 6;

    private static final int RECORD_SIZE
            = (ID_LENGTH + NAME_LENGTH + SPECIALTY_LENGTH
            + PHONE_LENGTH + EMAIL_LENGTH
            + START_HOUR_LENGTH + END_HOUR_LENGTH) * 2 + 1;

    private final String filePath = "doctor.dat";

    public ArrayList<Doctor> listDoctors() {

        ArrayList<Doctor> list = new ArrayList<>();

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {

            long recordCount = file.length() / RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {

                long position = i * RECORD_SIZE;

                file.seek(position);

                String id = leerTexto(file, ID_LENGTH);
                String fullName = leerTexto(file, NAME_LENGTH);
                String specialty = leerTexto(file, SPECIALTY_LENGTH);
                String phoneNumber = leerTexto(file, PHONE_LENGTH);
                String email = leerTexto(file, EMAIL_LENGTH);

                LocalTime startHour
                        = LocalTime.parse(leerTexto(file, START_HOUR_LENGTH));

                LocalTime endHour
                        = LocalTime.parse(leerTexto(file, END_HOUR_LENGTH));

                boolean active = file.readBoolean();

                Doctor doctor = new Doctor();

                doctor.setId(id);
                doctor.setFullName(fullName);
                doctor.setSpecialty(specialty);
                doctor.setPhoneNumber(phoneNumber);
                doctor.setEmail(email);
                doctor.setStartHour(startHour);
                doctor.setEndHour(endHour);
                doctor.setActive(active);

                list.add(doctor);
            }

        } catch (Exception exception) {
            System.out.println("Error al listar medicos: " + exception.getMessage());
        }

        return list;
    }
}
