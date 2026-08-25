/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServicePatients;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Patient;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class UpdatePatient extends FileUtil {

    private static final int NAME_LENGTH = 50;
    private static final int DATE_LENGTH = 10;
    private static final int GENDER_LENGTH = 1;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50;
    private static final int BLOOD_TYPE_LENGTH = 3;

    private static final int Tamanio_Registro
            = 4 + (NAME_LENGTH + DATE_LENGTH + GENDER_LENGTH
            + PHONE_LENGTH + EMAIL_LENGTH + BLOOD_TYPE_LENGTH) * 2 + 1;
    private final String rutaArchivo = "patients.dat";

    public boolean update(Patient uppdate) {
        try (RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")) {
            long cantidadRegistros = archivo.length() / Tamanio_Registro;
            for (long i = 0; i < cantidadRegistros; i++) {
                long posicion = i * Tamanio_Registro;
                archivo.seek(posicion);
                int ineLeido = archivo.readInt();
                
                if (ineLeido == uppdate.getIne()) {
                    archivo.seek(posicion);
                    archivo.writeInt(uppdate.getIne());
                    escribirTexto(archivo, uppdate.getFullName(), NAME_LENGTH);
                    escribirTexto(archivo, uppdate.getBirthdate().toString(), DATE_LENGTH);
                    escribirTexto(archivo, uppdate.getGender(), GENDER_LENGTH);
                    escribirTexto(archivo, uppdate.getPhoneNumber(), PHONE_LENGTH);
                    escribirTexto(archivo, uppdate.getEmail(), EMAIL_LENGTH);
                    escribirTexto(archivo, uppdate.getBloodType(), BLOOD_TYPE_LENGTH);
                    return true;
                }
            }

        } catch (Exception exception) {
            System.out.println("Error al actualizar paciente: " + exception.getMessage());
        }
        return false;
    }

}
