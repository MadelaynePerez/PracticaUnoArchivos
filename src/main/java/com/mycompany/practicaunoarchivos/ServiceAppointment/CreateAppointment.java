/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServiceAppointment;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Appointment;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class CreateAppointment extends FileUtil {
    
    public static final int ID_LENGTH = 36;
    public static final int UUID_DOCTOR_LENGTH = 36;
    public static final int DATE_LENGTH = 10;
    public static final int START_HOUR_LENGTH = 6;
    public static final int REASON_LENGTH = 100;
    public static final int STATUS_LENGTH = 15;
    public static final int OBSERVATION_LENGTH = 150;

    public static final int RECORD_SIZE =
            4 + (ID_LENGTH + UUID_DOCTOR_LENGTH + DATE_LENGTH
            + START_HOUR_LENGTH + REASON_LENGTH
            + STATUS_LENGTH + OBSERVATION_LENGTH) * 2 + 1;

    private final String filePath = "appointment.dat";

    public void createAppointment(Appointment appointment) {

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {

            file.seek(file.length());

            file.writeInt(appointment.getInePaciente());
            escribirTexto(file, appointment.getId(), ID_LENGTH);
            escribirTexto(file, appointment.getUUIdDoctor(), UUID_DOCTOR_LENGTH);
            escribirTexto(file, appointment.getDate().toString(), DATE_LENGTH);
            escribirTexto(file, appointment.getStartHour().toString(), START_HOUR_LENGTH);
            escribirTexto(file, appointment.getReason(), REASON_LENGTH);
            escribirTexto(file, appointment.isStatus(), STATUS_LENGTH);
            escribirTexto(file, appointment.getObservation(), OBSERVATION_LENGTH);
            file.writeBoolean(appointment.isDeleted());

        } catch (IOException exception) {
            System.out.println("Error al guardar cita: " + exception.getMessage());
        }
    }
    
    
}
