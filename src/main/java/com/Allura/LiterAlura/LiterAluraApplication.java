package com.Allura.LiterAlura;

import com.Allura.LiterAlura.repository.AutorRepository;
import com.Allura.LiterAlura.repository.IdiomaRepository;
import com.Allura.LiterAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.Allura.LiterAlura.principal.Principal;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	LibroRepository libroRepositorio;
	@Autowired
	AutorRepository autoRepositorio;
	@Autowired
	IdiomaRepository idiomaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepositorio, autoRepositorio, idiomaRepositorio);
		principal.menu();
	}
}
