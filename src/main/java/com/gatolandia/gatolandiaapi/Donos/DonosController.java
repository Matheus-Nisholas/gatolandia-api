package com.gatolandia.gatolandiaapi.Donos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DonosController {

    @GetMapping("donos/donos")
    public String donos() {return "Donos";}

    @PostMapping("donos/adicionar")
    public String criar() {return "Adicionar Dono";}

    @GetMapping("donos/mostrar")
    public String mostrar() {return "Mostrar Donos";}

    @GetMapping("donos/mostraId")
    public String mostraId() {return "Mostrar Dono por ID";}

    @PutMapping("donos/editar")
    public String editar() {return "Editar Dono";}

    @DeleteMapping("donos/excluirId")
    public String excluir() {return "Excluir Dono pelo ID";}

}
