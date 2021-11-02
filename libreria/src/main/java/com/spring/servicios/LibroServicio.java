
package com.spring.servicios;

import com.spring.entidades.Libro;
import com.spring.repositorios.AutorRepositorio;
import com.spring.repositorios.EditorialRepositorio;
import com.spring.repositorios.LibroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServicio {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio; 
    
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Integer restantes, Autor autor, Editorial editorial){
      
          if (libroRepositorio.existsById(titulo)) {
            throw new Exception("Ya existe un libro con el titulo indicado");
        }

            Libro libro = new Libro();

            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(prestados);
            libro.setEjemplaresRestantes(restantes);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepositorio.save(libro);
    }
    
     @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Integer restantes, Autor autor, Editorial editorial){
       libroRepositorio.modificar(isbn, titulo, anio, anio, ejemplares, prestados, restantes, autor, editorial);
    }
    
     @Transactional(readOnly = true)
     public List<Libro> consultarLibros(){
        return libroRepositorio.findAll();   
     
     }
     
     @Transactional(readOnly = true)
    public Libro buscarPorTitulo(String titulo) {
        return libroRepositorio.findById(titulo).orElse(null);
    }
     
     @Transactional
    public void habilitar(String titulo) {
        libroRepositorio.habilitar(titulo);
    }

    @Transactional
    public void eliminar(String titulo) {
        libroRepositorio.deleteById(titulo);
    }
}
    
