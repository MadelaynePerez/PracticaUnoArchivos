/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunoarchivos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana
 */


public abstract class FileUtil {

    protected void escribirTexto (RandomAccessFile archivo, String texto, int largoFijo) throws IOException{
        StringBuilder stringBuilderText= new StringBuilder(texto);
        
        while (stringBuilderText.length() < largoFijo) {
        stringBuilderText.append(' ');
          
        }   
         archivo.writeChars(stringBuilderText.substring(0, largoFijo));
    }
    
    protected String leerTexto (RandomAccessFile archivo, int largoFijo) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< largoFijo; i++){
         char guardarCaracter = archivo.readChar();
         stringBuilder.append(guardarCaracter);
           
        }
        return stringBuilder.toString().trim();
    }
}
