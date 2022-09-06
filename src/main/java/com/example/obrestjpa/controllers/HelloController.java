package com.example.obrestjpa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //Aca ponemos el URL al que queremos que vaya para obtener este metodo/funcion
    @GetMapping("/hola")
    //Aca creamos un metodo publico
    public String holaMundo() {
        return "hola Mundo";
    }

}
