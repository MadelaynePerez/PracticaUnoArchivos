/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServicePatients;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Patient;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class ListPatients extends FileUtil {

    private static final int NAME_LENGTH = 50;
    private static final int DATE_LENGTH = 10;
    private static final int GENDER_LENGTH = 1;
    private static final int PHONE_LENGTH = 15;
    private static final int EMAIL_LENGTH = 50;
    private static final int BLOOD_TYPE_LENGTH = 3;
    private static final int TAMANIO_REGISTRO
            = 4 + (NAME_LENGTH + DATE_LENGTH + GENDER_LENGTH + PHONE_LENGTH + EMAIL_LENGTH + BLOOD_TYPE_LENGTH) * 2 + 1;

    private final String rutaArchivo = "patients.dat";

    public ArrayList<Patient> listPatients() {
        ArrayList<Patient> lista = new ArrayList<>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw");
            long cantidadRegistro = archivo.length()/ TAMANIO_REGISTRO;
            for (long i = 0; i < cantidadRegistro; i++) {
                archivo.seek(i * TAMANIO_REGISTRO);
                int ine = archivo.readInt();
                String nombre = leerTexto(archivo, NAME_LENGTH);
                LocalDate fecha = LocalDate.parse(leerTexto(archivo, DATE_LENGTH));
                String genero = leerTexto(archivo, GENDER_LENGTH);
                String telefono = leerTexto(archivo, PHONE_LENGTH);
                String email = leerTexto(archivo, EMAIL_LENGTH);
                String tipoSangre = leerTexto(archivo, BLOOD_TYPE_LENGTH);
                boolean eliminado = archivo.readBoolean();

                if (!eliminado) {
                    lista.add(new Patient(ine, nombre, fecha, genero, telefono, email, tipoSangre, eliminado));
                }

            }
        } catch (Exception exception) {
            System.out.println("Error al listar pacientes: " + exception.getMessage());
        }
        return lista;
    }
}
