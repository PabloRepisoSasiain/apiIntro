package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Documento {

    public void init(){
        try{
            String ruta =".\\";
            String nombreArchivo = "informe.txt";
            String rutaArchivo = ruta+nombreArchivo;

            File file = new File(rutaArchivo);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("HOLA");
            bw.close();


        }catch (Exception e){

        }
    }
}
