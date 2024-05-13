package com.Allura.LiterAlura.repository;

import com.Allura.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
    List<Libro> findTituloByTituloContainsIgnoreCase(String nombre);
}
