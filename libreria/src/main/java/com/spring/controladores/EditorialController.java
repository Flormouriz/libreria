
package com.spring.controladores;

import com.spring.entidades.Editorial;
import com.spring.servicios.EditorialServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/editoriales")
public class EditorialController {
      @Autowired
    private EditorialServicio servicio;

    @GetMapping("/todos")
    public ModelAndView mostrarEditoriales() {
        ModelAndView mav = new ModelAndView("editoriales-listas");
        List<Editorial> editoriales = servicio.consultarEditoriales();
        mav.addObject("editoriales", editoriales);

        return mav;
    }
}
