package com.Allura.LiterAlura.repository;

import com.Allura.LiterAlura.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IdiomaRepository extends JpaRepository<Idioma, Integer>{
    List<Idioma> findBySiglas(String siglas);

}
