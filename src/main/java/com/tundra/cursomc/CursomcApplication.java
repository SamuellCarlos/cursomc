package com.tundra.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tundra.cursomc.domain.Categoria;
import com.tundra.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	public void run(String... args ) {
			Categoria cat1 = new Categoria(null, "informátia");
			Categoria cat2 = new Categoria(null, "Escritório");
			
			categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		}
	

}
