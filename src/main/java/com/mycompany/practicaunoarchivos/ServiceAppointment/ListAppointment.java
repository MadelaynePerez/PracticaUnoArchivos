/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.ServiceAppointment;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Appointment;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class ListAppointment extends FileUtil {

    private final String filePath = "appointment.dat";

    public ArrayList<Appointment> listAppointments() {
        ArrayList<Appointment> list = new ArrayList<>();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
           long recordCount = file.length() / CreateAppointment.RECORD_SIZE;
            for (long i = 0; i < recordCount; i++) {
                long position = i * CreateAppointment.RECORD_SIZE;

                file.seek(position);
                int inePaciente = file.readInt();
                String id = leerTexto(file, CreateAppointment.ID_LENGTH);
                String uuidDoctor = leerTexto(file, CreateAppointment.UUID_DOCTOR_LENGTH);
                LocalDate date = LocalDate.parse(leerTexto(file, CreateAppointment.DATE_LENGTH));
                LocalTime startHour = LocalTime.parse(leerTexto(file, CreateAppointment.START_HOUR_LENGTH));
               String reason = leerTexto(file, CreateAppointment.REASON_LENGTH);
                String status = leerTexto(file, CreateAppointment.STATUS_LENGTH);
                String observation = leerTexto(file, CreateAppointment.OBSERVATION_LENGTH);
                boolean deleted = file.readBoolean();

                if (!deleted) {
                    Appointment appointment = new Appointment();
                    appointment.setId(id);
                    appointment.setInePaciente(inePaciente);
                    appointment.setUUIdDoctor(uuidDoctor);
                    appointment.setDate(date);
                    appointment.setStartHour(startHour);
                    appointment.setReason(reason);
                    appointment.setStatus(status);
                    appointment.setObservation(observation);
                    appointment.setDeleted(deleted);

                    list.add(appointment);
                }
            }

        } catch (Exception exception) {
            System.out.println("Error al listar citas: " + exception.getMessage());
        }

        return list;
    }
}
