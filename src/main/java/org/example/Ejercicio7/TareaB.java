package org.example.Ejercicio7;

import java.util.Date;

public class TareaB extends TareaBase {
    private String estado;

    public TareaB (String estado, String titulo, String descripcion, String fechaLimite, Categoria categoria,Usuario usuario){
        super(titulo,descripcion,fechaLimite,categoria,usuario);
        this.estado=estado;
    }
}
