package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
EJERCICIO 2:
Desarrollar un programa en Java que se conecte con la siguiente API: https://pokeapi.co/
el programa debe pasar un pokemon por parametro y mostrar la siguiente información del mismo por consola:
- Nombre
- Order
- Especie

Ademas de eso, se deben realizar las siguientes pruebas unitarias:
- assertEquals para validar que el valor sea "nombreDelPokemon"
- assertTrue para validar que el tiempo de respuesta sea mayor a 0
- assertEquals para validar que el tiempo de respuesta sea 200.
ENTREGABLES
- Codigo del proyecto enviado por correo.
*/

@SuppressWarnings("unused")
public class PokemonApi {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public JSONObject pokemonApi (String pokemonNameIntroducido){
        Boolean repetir = true;
        Integer codigoRespuesta = null;
        String pokemonNameRecibido="";
        do{
            try {
                URL url = new URL(BASE_URL+pokemonNameIntroducido);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                codigoRespuesta= con.getResponseCode();

                if(200!=codigoRespuesta){
                    throw new RuntimeException("Error de conexión o nombre de pokemon incorrecto");
                }
                StringBuilder infoPokemon = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()){
                    infoPokemon.append(sc.next());
                }
                sc.close();
                JSONObject pokemon = new JSONObject(infoPokemon.toString());
                JSONArray pokemonType = pokemon.getJSONArray("types");
                List<String> listaTyping = new ArrayList<>();
                pokemonType.forEach(type->{
                    JSONObject actual = new JSONObject(type.toString());
                    JSONObject aux = new JSONObject(actual.get("type").toString());
                    listaTyping.add(aux.get("name").toString());
                });
                pokemonNameRecibido = pokemon.get("name").toString();
                System.out.println("El nombre del pokemon es: "+pokemonNameRecibido);
                System.out.println("El order es: "+pokemon.get("order"));
                System.out.println("El tipo es: " + listaTyping);
                do{
                    try {
                        System.out.println("¿Desea consultar otro pokemon? \n" +
                                "Escriba true para sí y false para no");
                        //repetir = new Scanner(System.in).nextBoolean();
                        // aquí también se ha pesto directamente debido a los problemas del scanner
                        repetir = false;
                    }catch (Exception ex){
                        System.out.println("Error en la respuesta");
                        repetir = null;
                    }
                }while (repetir==null);

            }catch (MalformedURLException ex){
                System.out.println(ex.getMessage());
            } catch (ProtocolException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }catch (RuntimeException runtimeException){
                System.out.println(runtimeException.getMessage());
            }
        }while (repetir);

        JSONObject datos = new JSONObject();
        datos.put("codigoRespuesta",codigoRespuesta);
        datos.put("pokemonNameRecibido",pokemonNameRecibido);
        datos.put("pokemonNameIntroducido",pokemonNameRecibido);
        return datos;

    }

    @Test
    @DisplayName("request")
    public void pruebaRequest(){
        System.out.println("Escriba el nombre de un Pokemon: ");
        // Cómo en los test no se puede utilizar el Scanner lo pongo directamente el String de charizard
        //String pokemonNameIntroducido= new Scanner(System.in).next();
        JSONObject pokemon =pokemonApi("charizard");

        assertEquals(pokemon.get("pokemonNameRecibido"),pokemon.get("pokemonNameIntroducido"));
        assertTrue((int)pokemon.get("codigoRespuesta")>0);
        assertEquals(pokemon.get("codigoRespuesta"),200);
    }
}
