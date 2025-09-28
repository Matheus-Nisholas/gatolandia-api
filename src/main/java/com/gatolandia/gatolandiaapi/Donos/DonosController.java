package com.gatolandia.gatolandiaapi.Donos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DonosController {

    @GetMapping("donos/exibir")
    public String exibirDonos() {return "Donos";}

    @PostMapping("donos/adicionar")
    public String adicionarDonos() {return "Adicionar Dono";}

    @GetMapping("donos/exibirPorId")
    public String exibirDonosPorId() {return "Mostrar Dono por ID";}

    @PutMapping("donos/editar")
    public String editarDonos() {return "Editar Dono";}

    @DeleteMapping("donos/excluirId")
    public String excluirDonosPorId() {return "Excluir Dono pelo ID";}

}
