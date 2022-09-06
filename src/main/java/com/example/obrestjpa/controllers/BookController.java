package com.example.obrestjpa.controllers;

import com.example.obrestjpa.entities.Book;
import com.example.obrestjpa.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Este seria el controlador de la entidad de Book, por ende se utiliza el atributo RestController
@RestController
public class BookController {
    //atributos
    BookRepository repository;

    //constructores
    public BookController(BookRepository repository) {
        this.repository = repository;
    }


    //CRUD sobre la entidad Book


    //Buscar todos los libros (lista de libros)
    @GetMapping("/api/findAll")
    //http://localhost:8080/api/findAll
    public List<Book> findAll() {
        //Este metodo devolveria todos los libros existentes en la base de datos
        return repository.findAll();
    }


    //Buscar solo libros en base de dato segun ID
    @GetMapping("/api/find/{id}")
    //La hacemos ResponseEntity para poder determinar si encontro o no el libro, y devolver error
    public ResponseEntity <Book> findOneById(@PathVariable Long id) {
        //PathVariable lo que hace es vincular el parametro "Long id" con el "{id}" del URL

        //El Optional <Book> lo que hace es determinar si hay libro segun el ID pasado por parametro
        Optional <Book> bookOpt = repository.findById(id);

        //Esto haria que la respuesta o fuera un 202 OK (si se encontro el libro) o un 404 not found (un error)
        if(bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    //Crear un libro
    //PostMapping es utilzado para crear algo en la base de datos
    @PostMapping("/api/createBook")
    //RequestBody se utiliza para cargar la peticion que se encuentre en el body, y finalmente guardarla en la base de datos
    public Book createBook(@RequestBody Book book) {
        //Guardamos el libro que se paso por parametro
        return repository.save(book);
    }


    //Editar un libro
    @PostMapping("/api/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return repository.save(book);
    }

    //Borrar un libro
    @DeleteMapping("/api/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
