package com.example.recycleview.model;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import java.net.URL;

public class Persona {

    private Integer Id;
    private String Nombre;
    private  String Apellido;
    private Integer Edad;
    private String Telefono;


    public Persona(Integer id, String nombre, String apellido, Integer edad, String telefono)
    {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Telefono = telefono;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public String getTelefono() { return Telefono; }

    public void setTelefono(String telefono) { Telefono = telefono; }

    public  static View.OnClickListener llamar(final Persona p)
    {
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Intent.ACTION_CALL);
                int1.setData(Uri.parse("tel: "+p.getTelefono().toString()));
                v.getContext().startActivity(int1);
            }
        };

        return click;
    }


}
