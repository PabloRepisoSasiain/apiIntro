package org.example;
/*
Ejercicio 5:
        Considere una clase llamada EmailValidator que se encarga de validar direcciones de correo electrónico. Donde el usuairo ingresa su email y su edad por consola.
        El método principal de esta clase es emailEsValido, que toma una cadena de texto como entrada y devuelve un valor booleano que indica si la dirección de correo electrónico es válida o no.
        Escribe pruebas unitarias para la clase EmailValidator que cubran diferentes escenarios posibles. A continuación se muestra un ejemplo de cómo podrían verse algunas de estas pruebas.
        Ademas, de las pruebas unitarias, realizar pruebas funcionales de borde para los valores de la edad ingresados.
        Realizarlo para al menos 5 usuarios.

        ENTREGABLES:
        - Codigo del proyecto.
 */

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidator {

    public Integer ejercicio5 (){
        Integer edad =0;
        try {
            boolean emailCorrecto = false;
            do{
                System.out.println("Escriba un email: ");
                String email = String.valueOf(new Scanner(System.in));
                emailCorrecto = emailEsValido(email);
                if (!emailCorrecto){
                    System.out.println("Email con formato incorrecto. Este no puede contener acentuación ni caracteres extraños");
                }else{
                    System.out.println("El correo es: "+email);
                }
            }while (!emailCorrecto);

            boolean edadCorrecta = false;
            do{
                try{
                    System.out.println("Escribe su edad: ");
                    Integer edadIngresada = Integer.valueOf(new Scanner(System.in).toString());
                    if(edadIngresada>0){
                        edadCorrecta=false;
                    }else{
                        edadCorrecta=true;
                        edad=edadIngresada;
                    }
                }catch (Exception ex){
                    System.out.println("Error en el formato de la edad");
                    edadCorrecta=false;
                }
            }while (!edadCorrecta);
            System.out.println("La edad es: "+edad);
            return edad;
        }catch (Exception ex) {
            System.out.println(ex.getStackTrace());
            return edad;
        }
    }

    public static boolean  emailEsValido (String email){
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.+$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Test
    public void emailValidadoTest (){
        assertTrue(emailEsValido("a@g.es"));
        assertFalse(emailEsValido("a@b"));
        assertFalse(emailEsValido("abc2"));
    }

    @Test
    public void ejercicio5Test(){
        // Poner por consola en la edad 5
        assertEquals(5, ejercicio5());
        //Poner por consola en la edad 0
        assertNotNull(ejercicio5());
        //Poner en la edad null
        assertNotNull(ejercicio5());
        //Poner en la edad un número negativo
        assertNotNull(ejercicio5());
    }

}
