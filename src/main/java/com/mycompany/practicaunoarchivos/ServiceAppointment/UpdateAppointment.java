/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServiceAppointment;

import com.mycompany.practicaunoarchivos.FileUtil;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class UpdateAppointment extends FileUtil {

    private final String filePath = "appointment.dat";

    public boolean updateAppointment(String id, String nuevoMotivo, String nuevasObservaciones) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            long recordCount = file.length() / CreateAppointment.RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {
                long position = i * CreateAppointment.RECORD_SIZE;
                file.seek(position);

                file.skipBytes(4);
                String idRead = leerTexto(file, CreateAppointment.ID_LENGTH);

                if (idRead.equals(id)) {
                    file.skipBytes(CreateAppointment.UUID_DOCTOR_LENGTH * 2);
                    file.skipBytes(CreateAppointment.DATE_LENGTH * 2);
                    file.skipBytes(CreateAppointment.START_HOUR_LENGTH * 2);

                    escribirTexto(file, nuevoMotivo, CreateAppointment.REASON_LENGTH);
                    file.skipBytes(CreateAppointment.STATUS_LENGTH * 2);
                    escribirTexto(file, nuevasObservaciones, CreateAppointment.OBSERVATION_LENGTH);

                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar cita: " + e.getMessage());
        }
        return false;
    }

    public boolean markAsAttended(String id) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            long recordCount = file.length() / CreateAppointment.RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {
                long position = i * CreateAppointment.RECORD_SIZE;
                file.seek(position);

                file.skipBytes(4);
                String idRead = leerTexto(file, CreateAppointment.ID_LENGTH);

                if (idRead.equals(id)) {
                    file.skipBytes(CreateAppointment.UUID_DOCTOR_LENGTH * 2);
                    file.skipBytes(CreateAppointment.DATE_LENGTH * 2);
                    file.skipBytes(CreateAppointment.START_HOUR_LENGTH * 2);
                    file.skipBytes(CreateAppointment.REASON_LENGTH * 2);

                    escribirTexto(file, "atendida", CreateAppointment.STATUS_LENGTH);

                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al marcar cita: " + e.getMessage());
        }
        return false;
    }
}
