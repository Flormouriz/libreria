
package com.spring.servicios;

import com.spring.entidades.Autor;
import com.spring.repositorios.AutorRepositorio;
import com.spring.repositorios.EditorialRepositorio;
import org.springframework.stereotype.Service;
import com.spring.repositorios.LibroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Transactional
     public void crearAutor(String nombre){
         Autor autor = new Autor();
         
         autor.setNombre(nombre);
         
         autorRepositorio.save(autor);
     }
    
     @Transactional
     public void modificarAutor(String nombre){
       
         autorRepositorio.modificar(nombre);
     }
     
     @Transactional(readOnly = true)
     public List<Autor> consultarAutores(){
        return autorRepositorio.findAll();   
     
     }
     
   @Transactional(readOnly = true)
    public Autor buscarPorNombre(String nombre) {
        Optional<Autor> autorOptional = autorRepositorio.findById(nombre);
        return autorOptional.orElse(null);
    }

    @Transactional
    public void eliminar(String nombre) {
        autorRepositorio.deleteById(nombre);
    }
         
  }
     

