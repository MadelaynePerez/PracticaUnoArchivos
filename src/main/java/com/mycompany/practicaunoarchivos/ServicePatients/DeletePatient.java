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
public class DeletePatient extends FileUtil {

    private static final int NAME_LENGTH = 50;
    private static final int DATE_LENGTH = 10;
    private static final int GENDER_LENGTH = 1;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50;
    private static final int BLOOD_TYPE_LENGTH = 3;

    private static final int TAMANIO_REGISTRO
            = 4 + (NAME_LENGTH + DATE_LENGTH + GENDER_LENGTH + PHONE_LENGTH + EMAIL_LENGTH + BLOOD_TYPE_LENGTH) * 2 + 1;

    private final String rutaArchivo = "patients.dat";

    public boolean deletePatient(int ineBuscado) {
        try (RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")) {
            long cantidadRegistros = archivo.length() / TAMANIO_REGISTRO;

            for (long i = 0; i < cantidadRegistros; i++) {
                long posicion = i * TAMANIO_REGISTRO;
                archivo.seek(posicion);

                int ine = archivo.readInt();

                long posicionDelete = posicion + TAMANIO_REGISTRO - 1;
                archivo.seek(posicionDelete);
                boolean yaEliminado = archivo.readBoolean();

                if (ine == ineBuscado && !yaEliminado) {
                    archivo.seek(posicionDelete);
                    archivo.writeBoolean(true);
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar paciente: " + e.getMessage());
        }

        return false;
    }

}
