package org.example.ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Ejercicio 8 - Maximum Integration between Java and Database:
        Programa:
        Nos contrataron de la empresa Spotify para desarrollarles un programa nuevo que conecte con una base de datos.
        En lo referido al programa, debe poder almacenar la siguiente información por consola:
        - Nombre del artista
        - Genero
        - Cantidad de canciones
        - Cantidad de reproducciones
        - Cantidad de suscriptores

        Se debe generar 1 función que calcule la ganancia total del artista, la misma se calcula de la siguiente manera: Ganancia total = cantidad de reproducciones * 0.02
        (!)  Generarlo para al menos 3 artistas (!)
        La información se debe imprimir en un TXT de salida.

        ENTREGABLES:
        - Script de SQL que genere la tabla y  los usuarios.
        - Codigo del proyecto FUNCIONAL.

 */
public class mainEjercio8 {

    // EL pre-requisito es que los usuarios introduzcan correctamente los datos ya que hacer un try catch
    // vuelve el código denso y es siempre igual.

    public static void main(String[] args){
        ArtistaService artistaService = new ArtistaService();
        List<Artista> artistas = new ArrayList<>();

        try{
            System.out.println("¿Cuántos artistas quieres añadir? (Mayor o igual a 0)");
            Integer numeroArtistas = Integer.valueOf(new Scanner(System.in).next());
            while (numeroArtistas>30){
                System.out.println("Dime el nombre del artista");
                String nombre = new Scanner(System.in).next();
                System.out.println("Dime el género del artista");
                String genero = new Scanner(System.in).next();
                System.out.println("Dime el número de canciones del artista");
                Integer numeroCanciones = Integer.valueOf(new Scanner(System.in).next());
                System.out.println("Dime las reproducciones del artista");
                Integer reproducciones = Integer.valueOf(new Scanner(System.in).next());
                System.out.println("Dime los subscriptores del artista");
                Integer subscripciones = Integer.valueOf(new Scanner(System.in).next());
                Artista artistaActual = new Artista(nombre,genero,numeroCanciones,reproducciones,subscripciones);
                artistas.add(artistaActual);
                numeroArtistas--;
            }
            artistaService.escribirTxt(artistas);

        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }

    }
}
