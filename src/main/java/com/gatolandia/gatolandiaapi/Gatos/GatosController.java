package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GatosController {

    private GatosRepository gatosRepository;

    public GatosController(GatosRepository gatosRepository) {
        this.gatosRepository = gatosRepository;
    }

    @GetMapping("gatos/exibir")
    public List<GatosModel> exibirGatos() {
        return gatosRepository.findAll();
    }

    @PostMapping("gatos/adicionar")
    public String adicionarGatos() {return "Adicionar Gato";}

    @GetMapping("gatos/exibirPorid")
    public String exibirGatosPorId() {return "Mostrar Gato";}

    @PutMapping("gatos/editar")
    public String editarGatos() {return "Editar Gato";}

    @DeleteMapping("gatos/excluirId")
    public String excluirGatosPorI() {return "Excluir Gato pelo ID";}

}
