package com.example.vulcanussoft.carviewfinal;


public class Contacto {
    private String nombre;
    private String email;
    private String telefono;
    private String descripcion;
    private String fecha;
    private  int foto;

    public Contacto(int foto, String nombre, String email, String telefono, String fecha){
        this.nombre=nombre;
        this.email=email;
        this.telefono=telefono;
        this.fecha=fecha;
        this.foto=foto;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
