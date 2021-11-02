
package com.spring.servicios;

import com.spring.entidades.Editorial;
import com.spring.repositorios.AutorRepositorio;
import com.spring.repositorios.EditorialRepositorio;
import com.spring.repositorios.LibroRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServicio {
      @Autowired
    private EditorialRepositorio editorialRepositorio;
      
       @Autowired
    private AutorRepositorio autorRepositorio;
       
       @Autowired
    private LibroRepositorio libroRepositorio;
      
       @Transactional
     public void crearEditorial(String nombre){
         Editorial editorial = new Editorial();
         
         editorial.setNombre(nombre);
         
               editorialRepositorio.save(editorial);
     }
    
     @Transactional
     public void modificarEditorial(Integer id, String nombre){
        
         editorialRepositorio.modificar(id,nombre);
   
     }
     
     @Transactional(readOnly = true)
     public List<Editorial> consultarEditoriales(){
        return editorialRepositorio.findAll();   
     
     }
     
      @Transactional(readOnly = true)
    public Editorial buscarPorId(Integer id) {
        Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
        return editorialOptional.orElse(null);
    }

    @Transactional
    public void eliminar(Integer id) {
        editorialRepositorio.deleteById(id);
    }
}
