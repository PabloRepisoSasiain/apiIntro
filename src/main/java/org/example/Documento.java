package org.example;

import java.io.*;

public class Documento {

    public void init(){
        try{
            //ESCRIBIR
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

    public void leer(){
        try{
            String ruta =".\\";
            String nombreArchivo = "informe.txt";
            String rutaArchivo = ruta+nombreArchivo;
            File doc = new File(rutaArchivo);
            FileReader fr = new FileReader(doc);
            BufferedReader br = new BufferedReader(fr);

            String text = "";
            while ((text=br.readLine())!=null){
                System.out.println(text);
            }


        }catch (Exception ex){

        }

    }
}
