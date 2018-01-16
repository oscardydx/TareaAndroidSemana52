package com.example.vulcanussoft.carviewfinal.pojo;


public class Contacto {
    private String nombre;
    private String email;
    private String like;
    private String descripcion;
    private String fecha;
    private  int foto;

    public Contacto(int foto, String nombre, String email, String like, String fecha){
        this.nombre=nombre;
        this.email=email;
        this.like=like;
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
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
