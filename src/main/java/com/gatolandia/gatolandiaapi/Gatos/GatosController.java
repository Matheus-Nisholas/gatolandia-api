package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GatosController {

    @GetMapping("/gatos")
    public String gatos() {return "Gatos";}

    // CREATE
    @PostMapping("/adicionar")
    public String criar() {return "Adicionar Gato";}
    // READ
    @GetMapping("/mostrar")
    public String mostrar() {return "Mostrar Gato";}

    // READ POR ID
    @GetMapping("/mostrarId")
    public String mostrarId() {return "Mostrar Gato por ID";}

    // UPDATE
    @PutMapping("/editar")
    public String editar() {return "Editar Gato";}

    // DELETE
    @DeleteMapping("excluirId")
    public String excluir() {return "Excluir Gato pelo ID";}

}
