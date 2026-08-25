/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.DoctorService;

import com.mycompany.practicaunoarchivos.FileUtil;
import com.mycompany.practicaunoarchivos.Models.Doctor;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class UpdateDoctor extends FileUtil {

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

    public boolean updateDoctor(Doctor doctorUpdated) {

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {

            long recordCount = file.length() / RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {

                long position = i * RECORD_SIZE;

                file.seek(position);

                String idRead = leerTexto(file, ID_LENGTH);

                if (idRead.equals(doctorUpdated.getId())) {

                    file.seek(position);

                    escribirTexto(file, doctorUpdated.getId(), ID_LENGTH);
                    escribirTexto(file, doctorUpdated.getFullName(), NAME_LENGTH);
                    escribirTexto(file, doctorUpdated.getSpecialty(), SPECIALTY_LENGTH);
                    escribirTexto(file, doctorUpdated.getPhoneNumber(), PHONE_LENGTH);
                    escribirTexto(file, doctorUpdated.getEmail(), EMAIL_LENGTH);
                    escribirTexto(file, doctorUpdated.getStartHour().toString(), START_HOUR_LENGTH);
                    escribirTexto(file, doctorUpdated.getEndHour().toString(), END_HOUR_LENGTH);
                    file.writeBoolean(doctorUpdated.isActive());

                    return true;
                }
            }

        } catch (Exception exception) {
            System.out.println("Error al actualizar medico: " + exception.getMessage());
        }

        return false;
    }
}
