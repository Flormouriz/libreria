
package com.spring.controladores;

import com.spring.entidades.Autor;
import com.spring.servicios.AutorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autores")
public class AutorController {
     @Autowired
    private AutorServicio servicio;

    @GetMapping("/todos")
    public ModelAndView mostrarAutores() {
        ModelAndView mav = new ModelAndView("autores-listas");
        List<Autor> autores = servicio.consultarAutores();
        mav.addObject("autores", autores);

        return mav;
    }
}
