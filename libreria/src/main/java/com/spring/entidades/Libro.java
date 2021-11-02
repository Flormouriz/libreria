
package com.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Libro {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String titulo;
        
    private Long isbn;

    private Integer anio;

    private Integer ejemplares;
   
    private Integer ejemplaresPrestados;

    private Integer ejemplaresRestantes;

    @ManyToOne 
    private Autor autor;

    @ManyToOne
    private Editorial editorial;
    
    private Boolean alta;

    public Libro() {
        alta = true;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }


        @Override
    public String toString() {
        return String.format("%-16s%-40s%-25s%-15s%-8s%-12s%-12s%-12s%n", isbn, titulo, autor.getNombre(), editorial.getNombre(), anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes);
    }
}

 


