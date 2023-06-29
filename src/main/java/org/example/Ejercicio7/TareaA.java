package org.example.Ejercicio7;

import java.util.Date;

public class TareaA extends TareaBase{
    private Categoria subCategoria;

    public TareaA (Categoria subCategoria,String titulo, String descripcion, String fechaLimite, Categoria categoria,Usuario usuario){
        super(titulo,descripcion,fechaLimite,categoria,usuario);
        this.subCategoria=subCategoria;
    }
}
