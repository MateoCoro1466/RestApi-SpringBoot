package com.example.obrestjpa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    //atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private Integer pages;
    private LocalDate releaseDate;

    //constructores

    public Book() {
    }

    public Book(Long id, String name, String genre, Integer pages, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.pages = pages;
        this.releaseDate = releaseDate;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    //toString

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
