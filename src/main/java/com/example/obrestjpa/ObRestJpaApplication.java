package com.example.obrestjpa;

import com.example.obrestjpa.entities.Book;
import com.example.obrestjpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//Crear libros
		Book libro = new Book(null, "Como agua para chocolate", "Romantico", 120, LocalDate.now());
		Book libro2 = new Book(null, "Viaje al centro de la tierra", "Aventura", 160, LocalDate.now());

		//Almacenar libros
		repository.save(libro);
		repository.save(libro2);
		System.out.println("Cantidad de libros en la base de datos: " + repository.findAll().size());

		//Mostrar todos los libros que hay
		System.out.println(repository.findAll());

		//Borrar libro
		System.out.println("Cantidad de libros en la base de datos: " + repository.findAll().size());
	}

}
