package com.Allura.LiterAlura.Principal;

import com.Allura.LiterAlura.service.*;

public class Principal {
    private static final String URL_BASE = "http://gutendex.com/books/";
    private Connection consumo = new Connection();
    private Conversion conversor = new Conversion();

    public void menu(){
        var json = consumo.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}
