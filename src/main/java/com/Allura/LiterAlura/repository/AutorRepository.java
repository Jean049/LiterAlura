package com.Allura.LiterAlura.repository;

import com.Allura.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    List<Autor> findIdByNombreContainsIgnoreCase(String nombre);
    List<Autor> findByFechaNacimientoBetween(int fechaNacimiento, int limite);
}
