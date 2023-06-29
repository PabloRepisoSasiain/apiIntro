package org.example.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceTask {
    // Voy a dar cómo pre-requisito que el usaurio mientras use SCAN meta correctamente los datos
    // para no alargar el código en comprobaciones cómo he hecho anteriormente

    public void init (){
        //Con esto creas un usuario y 5 task del A y 5 del B
        int count=0;
        Usuario usuario = createUser();
        List<TareaA> listaA = new ArrayList<>();
        List<TareaB> listaB = new ArrayList<>();
        while (count<5){
            createTaskB(usuario);
            listaA.add(createTaskA(usuario));
            listaB.add(createTaskB(usuario));
            count++;
        }
        System.out.println("Lista A: "+listaA);
        System.out.println("Lista B: "+listaB);
    }

    public static Usuario createUser(){
        try {
            System.out.println("Escriba su nombre");
            String nombre=new Scanner(System.in).toString();
            System.out.println("Escriba sus apellidos");
            String apellidos=new Scanner(System.in).toString();
            System.out.println("Escriba su email");
            String email=new Scanner(System.in).toString();
            return new Usuario(nombre,apellidos,email);
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
            throw new RuntimeException("Error al crear el usuario");
        }
    }

    public static TareaA createTaskA(Usuario usuario){
        try{
            System.out.println("Escriba el título");
            String titulo=new Scanner(System.in).toString();
            System.out.println("Escriba la descripcion");
            String descripcion=new Scanner(System.in).toString();
            System.out.println("Escriba la fecha límite");
            String fechaLimite=new Scanner(System.in).toString();
            System.out.println("Escriba la Categoria");
            Categoria categoria=Categoria.valueOf(new Scanner(System.in).toString());
            System.out.println("Escriba la sub categoria");
            Categoria subCategoria=Categoria.valueOf(new Scanner(System.in).toString());
            return new TareaA (subCategoria, titulo, descripcion, fechaLimite, categoria,usuario);
        }catch (Exception ex){
            throw new RuntimeException("Error al crear la Tarea A");
        }
    }

    public static TareaB createTaskB(Usuario usuario){
        try{
            System.out.println("Escriba el título");
            String titulo=new Scanner(System.in).toString();
            System.out.println("Escriba la descripcion");
            String descripcion=new Scanner(System.in).toString();
            System.out.println("Escriba la fecha límite");
            String fechaLimite=new Scanner(System.in).toString();
            System.out.println("Escriba la Categoria");
            Categoria categoria=Categoria.valueOf(new Scanner(System.in).toString());
            System.out.println("Escriba la sub categoria");
            String estado=new Scanner(System.in).toString();
            return new TareaB (estado, titulo, descripcion, fechaLimite, categoria,usuario);
        }catch (Exception ex){
            throw new RuntimeException("Error al crear la Tarea A");
        }
    }
}
