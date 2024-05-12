package com.Allura.LiterAlura.repository;

import com.Allura.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
    List<Libro> findTituloByTituloContainsIgnoreCase(String nombre);
}
