package com.Allura.LiterAlura.model;

import com.Allura.LiterAlura.model.DTA.DatosAutor;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fechaNacimiento;
    private String nombre;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.nombre = datosAutor.nombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Autor:  \nNombre: " + nombre + "    \nFechaNacimiento: " + fechaNacimiento +
                "\n Libros: "+libros;
    } 
    
}
