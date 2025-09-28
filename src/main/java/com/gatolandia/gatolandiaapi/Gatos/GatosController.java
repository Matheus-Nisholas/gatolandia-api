package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GatosController {

    @GetMapping("gatos/exibir")
    public String exibirGatos() {return "Gatos";}

    @PostMapping("gatos/adicionar")
    public String adicionarGatos() {return "Adicionar Gato";}

    @GetMapping("gatos/exibirPorid")
    public String exibirGatosPorId() {return "Mostrar Gato";}

    @PutMapping("gatos/editar")
    public String editarGatos() {return "Editar Gato";}

    @DeleteMapping("gatos/excluirId")
    public String excluirGatosPorI() {return "Excluir Gato pelo ID";}

}
