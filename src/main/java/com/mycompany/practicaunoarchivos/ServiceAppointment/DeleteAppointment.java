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
public class DeleteAppointment extends FileUtil {

    private final String filePath = "appointment.dat";

    public boolean deleteAppointment(String id) {

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {

            long recordCount = file.length() / CreateAppointment.RECORD_SIZE;

            for (long i = 0; i < recordCount; i++) {

                long position = i * CreateAppointment.RECORD_SIZE;

                file.seek(position);

                file.skipBytes(4);

                String idRead = leerTexto( file,  CreateAppointment.ID_LENGTH  );

                if (idRead.equals(id)) {

                    long deletedPosition  = position + CreateAppointment.RECORD_SIZE - 1;

                    file.seek(deletedPosition);

                    file.writeBoolean(true);

                    return true;
                }
            }

        } catch (Exception exception) {

            System.out.println(
                    "Error al eliminar cita: "
                    + exception.getMessage()
            );
        }

        return false;
    }
}
