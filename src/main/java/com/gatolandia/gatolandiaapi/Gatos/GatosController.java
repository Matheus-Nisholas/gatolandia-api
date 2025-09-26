package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GatosController {

    @GetMapping("/gatos")
    public String gatos() {return "Gatos";}
}
