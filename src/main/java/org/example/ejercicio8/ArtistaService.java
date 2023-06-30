package org.example.ejercicio8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ArtistaService {
    public static final String BASE_URL = ".\\src\\main\\resources\\";

    public void escribirTxt (List<Artista> artistas){
        StringBuilder textoCompleto= new StringBuilder();
        artistas.forEach(artista -> {
            textoCompleto.append(artista.toString()+"\n");
        });

        try {
            File file = new File(BASE_URL+"artistas.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(textoCompleto));
            bw.close();
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }
}
