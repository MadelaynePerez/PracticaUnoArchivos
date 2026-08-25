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
public class CancelAppointment extends FileUtil {

    private final String filePath = "appointment.dat";

    public boolean cancelAppointment(String id) {

        try (RandomAccessFile file  = new RandomAccessFile(filePath, "rw")) {
            long recordCount = file.length() / CreateAppointment.RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {
                long position = i * CreateAppointment.RECORD_SIZE;
                file.seek(position);
                file.skipBytes(4);
                String idRead  = leerTexto(file, CreateAppointment.ID_LENGTH);
                if (idRead.equals(id)) {
                    file.skipBytes(CreateAppointment.UUID_DOCTOR_LENGTH * 2);
                    file.skipBytes(CreateAppointment.DATE_LENGTH * 2);
                    file.skipBytes(CreateAppointment.START_HOUR_LENGTH * 2);
                    file.skipBytes(CreateAppointment.REASON_LENGTH * 2);

                    escribirTexto(file,"cancelada",CreateAppointment.STATUS_LENGTH );

                    return true;
                }
            }

        } catch (Exception exception) {
            System.out.println("Error al cancelar cita: " + exception.getMessage());
        }

        return false;
    }
}
