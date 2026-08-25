/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos.DoctorService;

import com.mycompany.practicaunoarchivos.FileUtil;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */
public class ChangeStatusDoctor extends FileUtil {

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

    public boolean changeStatus(String id, boolean active) {

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {

            long recordCount = file.length() / RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {

                long position = i * RECORD_SIZE;

                file.seek(position);

                String idRead = leerTexto(file, ID_LENGTH);

                if (idRead.equalsIgnoreCase(id.trim())) {

                    long statusPosition = position + RECORD_SIZE - 1;

                    file.seek(statusPosition);
                    file.writeBoolean(active);

                    return true;
                }
            }

        } catch (Exception exception) {
            System.out.println("Error al cambiar estado: " + exception.getMessage());
        }

        return false;
    }

}
