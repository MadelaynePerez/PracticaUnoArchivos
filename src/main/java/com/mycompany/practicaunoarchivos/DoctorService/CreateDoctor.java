/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.DoctorService;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Doctor;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class CreateDoctor extends FileUtil {

    private static final int ID_LENGTH = 36;
    private static final int NAME_LENGTH = 50;
    private static final int SPECIALTY_LENGTH = 50;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50;
    private static final int START_HOUR_LENGTH = 6;
    private static final int END_HOUR_LENGTH = 6;

    private final String rutaArchivo = "doctor.dat";

    public void createDoctor(Doctor doctor) {
        try (RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")) {
            archivo.seek(archivo.length());
            escribirTexto(archivo, doctor.getId(), ID_LENGTH);
            escribirTexto(archivo, doctor.getFullName(), NAME_LENGTH);
            escribirTexto(archivo, doctor.getSpecialty(), SPECIALTY_LENGTH);
            escribirTexto(archivo, doctor.getPhoneNumber(), PHONE_LENGTH);
            escribirTexto(archivo, doctor.getEmail(), EMAIL_LENGTH);
            escribirTexto(archivo, doctor.getStartHour().toString(), START_HOUR_LENGTH);
            escribirTexto(archivo, doctor.getEndHour().toString(), END_HOUR_LENGTH);

            archivo.writeBoolean(doctor.isActive());

        } catch (IOException exception) {
            System.out.println("Error al guardar paciente: " + exception.getMessage());
        }

    }
}
