package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GatosController {

    @GetMapping("gatos/gatos")
    public String gatos() {return "Gatos";}

    // CREATE
    @PostMapping("gatos/adicionar")
    public String criar() {return "Adicionar Gato";}
    // READ
    @GetMapping("gatos/mostrar")
    public String mostrar() {return "Mostrar Gato";}

    // READ POR ID
    @GetMapping("gatos/mostrarId")
    public String mostrarId() {return "Mostrar Gato por ID";}

    // UPDATE
    @PutMapping("gatos/editar")
    public String editar() {return "Editar Gato";}

    // DELETE
    @DeleteMapping("gatos/excluirId")
    public String excluir() {return "Excluir Gato pelo ID";}

}
