package com.example.apprealm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;
    private String apellidos;
    private String edad;
    private String direccion;
    private int telefono;

    public User(String nombre, String apellidos, String edad, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Id: '" + id + '\'' +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido '" + apellidos + '\'' +
                ", Edad: '" + edad + '\'' + '\'' +
                ", Teléfono '" + telefono + '\'' +
                ", Dirección '" + direccion + '\'' + "\n";
    }
}
