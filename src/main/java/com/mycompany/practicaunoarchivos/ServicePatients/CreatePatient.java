/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServicePatients;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Patient;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class CreatePatient extends FileUtil {

    private static final int NAME_LENGTH = 50;
    private static final int DATE_LENGTH = 10;
    private static final int GENDER_LENGTH = 1;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50; 
    private static final int BLOOD_TYPE_LENGTH = 3;

    private final String rutaArchivo = "patients.dat";

    public void createPatient(Patient patient) {
        try {
            if (existePaciente(patient.getIne())) {
                System.out.println("Ya existe un paciente con ese número de identificación.");
                return;
            }
        } catch (IOException e) {
            System.out.println("Error al verificar duplicado: " + e.getMessage());
        }
        try (RandomAccessFile archivo = new RandomAccessFile("patients.dat", "rw")) {
            archivo.seek(archivo.length());
            archivo.writeInt(patient.getIne());
            escribirTexto(archivo, patient.getFullName(), NAME_LENGTH);
            escribirTexto(archivo, patient.getBirthdate().toString(), DATE_LENGTH);
            escribirTexto(archivo, patient.getGender(), GENDER_LENGTH);
            escribirTexto(archivo, patient.getPhoneNumber(), PHONE_LENGTH);
            escribirTexto(archivo, patient.getEmail(), EMAIL_LENGTH);
            escribirTexto(archivo, patient.getBloodType(), BLOOD_TYPE_LENGTH);
            archivo.writeBoolean(patient.getDelete());

        } catch (IOException exception) {
            System.out.println("Error al guardar paciente: " + exception.getMessage());
        }

    }

    private boolean existePaciente(int ine) throws IOException {
        java.io.File archivoFile = new java.io.File(rutaArchivo);
        if (!archivoFile.exists()) {
            return false;
        }
        long tamanioRegistro = 4 + (NAME_LENGTH + DATE_LENGTH + GENDER_LENGTH
                + PHONE_LENGTH + EMAIL_LENGTH + BLOOD_TYPE_LENGTH) * 2 + 1;

        try (RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "r")) {
            long cantidadRegistros = archivo.length() / tamanioRegistro;
            for (long i = 0; i < cantidadRegistros; i++) {
                archivo.seek(i * tamanioRegistro);
                int ineLeido = archivo.readInt();
                if (ineLeido == ine) {
                    return true;
                }
            }
        }
        return false;
    }
}
