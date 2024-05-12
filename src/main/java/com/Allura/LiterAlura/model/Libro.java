package com.Allura.LiterAlura.model;

import com.Allura.LiterAlura.model.DTA.DatosAutor;
import com.Allura.LiterAlura.model.DTA.DatosIdiomas;
import com.Allura.LiterAlura.model.DTA.DatosLibros;
import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Idioma idioma;
    private Double numeroDescargas;
    @Column(name = "idApi")
    private int idApi;

    public Libro() {}
    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idApi = datosLibros.id();
        this.autor = new Autor(datosLibros.autor().isEmpty() ?
                new DatosAutor("Unknown", 0) :
                datosLibros.autor().get(0));
        this.idioma = new Idioma(new DatosIdiomas(datosLibros.idiomas()));
        this.numeroDescargas = datosLibros.numeroDescargas();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public int getIdApi() {
        return idApi;
    }

    public void setIdApi(int idApi) {
        this.idApi = idApi;
    }

    @Override
    public String toString() {
        return "Libro:  \nTitulo: " + titulo + "    \nAutor: " + autor + "  \nIdiomas: " + idioma + "  \nNumeroDescargas: "
                + numeroDescargas;
    } 
}
