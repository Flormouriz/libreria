
package com.spring.controladores;

import com.spring.entidades.Libro;
import com.spring.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/libros")
public class LibroController {
      @Autowired
    private LibroServicio servicio;

    @GetMapping("/todos")
    public ModelAndView mostrarLibros() {
        ModelAndView mav = new ModelAndView("libros-listas");
        List<Libro> libros = servicio.consultarLibros();
        mav.addObject("libros", libros);

        return mav;
    }
}







  
