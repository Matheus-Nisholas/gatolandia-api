package com.gatolandia.gatolandiaapi.Donos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DonosController {

    @GetMapping("/donos")
    public String donos() {return "Donos";}

    @PostMapping("/adicionar")
    public String criar() {return "Adicionar Dono";}

    @GetMapping("/mostrar")
    public String mostrar() {return "Mostrar Donos";}

    @GetMapping("mostraId")
    public String mostraId() {return "Mostrar Dono por ID";}

    @PutMapping("/editar")
    public String editar() {return "Editar Dono";}

    @DeleteMapping("/excluirId")
    public String excluir() {return "Excluir Dono pelo ID";}

}
