package com.example.vulcanussoft.carviewfinal.pojo;


public class Mascota {
    private String nombre;
    private String email;
    private int like;
    private String descripcion;
    private String fecha;
    private  int foto;
    private int id;

    public Mascota(int foto, String nombre, String email, int like, String fecha){
        this.nombre=nombre;
        this.email=email;
        this.like=like;
        this.fecha=fecha;
        this.foto=foto;

    }

    public Mascota() {

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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
