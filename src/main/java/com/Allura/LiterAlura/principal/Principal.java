package com.Allura.LiterAlura.principal;

import com.Allura.LiterAlura.model.*;
import com.Allura.LiterAlura.model.DTA.*;
import com.Allura.LiterAlura.repository.*;
import com.Allura.LiterAlura.service.*;
import java.util.*;

public class Principal {
    //Instancias de conexion y conversion
    private Connection consumo = new Connection();
    private Conversion conversor = new Conversion();
    private  LibroRepository libroRepositorio;
    private  AutorRepository autoRepositorio;
    private IdiomaRepository idiomaRepositorio;
    private Scanner entrada = new Scanner(System.in);

    public Principal(LibroRepository libroRepositorio, AutorRepository autoRepositorio, IdiomaRepository idiomaRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.autoRepositorio = autoRepositorio;
        this.idiomaRepositorio = idiomaRepositorio;
    }

    public void menu(){
        int opcion = 0;
        String menuMensaje = """
            Bienvenido al sistema de Libros Allura
            --------------------------------------
            1. Buscar libro por titulo
            2. Listar libros registrados
            3. Listar Autores registrados
            4. Listar Autores vivos en un determinado año
            5. Listar libros por idioma
            6. Top 10 libros mas descargados
            9. Salir
            """;

        while (opcion != 9) {
            System.out.println(menuMensaje);
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    buscarPNombre();
                    break;
                case 2:
                    listarBuscados();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    ranking10(

                    );
                    break;
                default:
                    break;
            }
            
        }
    }

    public void buscarPNombre(){
        entrada.nextLine();
        //Busqueda por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        String tituloL = entrada.nextLine();
        Optional<String> resultado = consumo.buscar(tituloL);
        if(resultado.isPresent() &&
                conversor.obtenerDatos(resultado.get(), Datos.class).resultados().size() > 0){

            Datos resultConsulta = conversor
                    .obtenerDatos(resultado.get(), Datos.class);
            DatosLibros resultLibro = resultConsulta.resultados().get(0);
            System.out.println(resultLibro);
            Autor resultAutor = new Autor(resultLibro.autor().isEmpty() ?
                    new DatosAutor("Desconocido", 0) :
                    resultLibro.autor().get(0));

            Libro libroG = new Libro(resultLibro);
            Idioma idiomaG = libroG.getIdioma();
            //consulta de exitencia en base de datos
            List<Autor> autorBase = autoRepositorio.findIdByNombreContainsIgnoreCase(resultAutor.getNombre());

            List<Libro> libroBase = libroRepositorio.findTituloByTituloContainsIgnoreCase(libroG.getTitulo());

            List<Idioma> idiomasBase = idiomaRepositorio.findBySiglas(idiomaG.getSiglas());

            //verificacion de idiomas en la base
            if (!idiomasBase.isEmpty()){
                idiomasBase.forEach(i -> {
                    if (idiomaG.getSiglas().contains(i.getSiglas())){
                        libroG.setIdioma(i);
                    } else {
                        idiomaRepositorio.save(idiomaG);
                    }
                });
            } else idiomaRepositorio.save(idiomaG);

            //verificacion de autores en la base
            if (autorBase.size() == 0 && libroBase.size() == 0){
                autoRepositorio.save(resultAutor);
                libroG.setAutor(resultAutor);
                libroRepositorio.save(libroG);
            } else if (!autorBase.isEmpty() && libroBase.isEmpty()){
                libroG.setAutor(autorBase.get(0));
                libroRepositorio.save(libroG);
            }
            System.out.println(libroG);
        } else {
            System.out.println("No se encontro el libro que buscas");
        }

    }

    public void listarBuscados(){
        List<Libro> libros = libroRepositorio.findAll();
        if (!libros.isEmpty()){
            System.out.println("Los libros buscados son: ");
            libros.forEach(System.out::println);
        } else {
            System.out.println("No hay ningun libro guardado");
        }
    }

    public void mostrarLibrosBuscados(){

    }

    public void ranking10(){
        //Top 10 mas descargados
        System.out.println("Top 10 de los libros mas descargados: ");
        Optional<String> json = consumo.obtener();
        var datos = conversor.obtenerDatos(json.orElse(null), Datos.class);
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);
    }
}
