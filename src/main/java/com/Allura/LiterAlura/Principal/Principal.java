package com.Allura.LiterAlura.Principal;

import com.Allura.LiterAlura.model.Datos;
import com.Allura.LiterAlura.service.*;
import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "http://gutendex.com/books/";
    private Connection consumo = new Connection();
    private Conversion conversor = new Conversion();
    Scanner entrada = new Scanner(System.in);

    public void menu(){
        var json = consumo.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);
    }
}
