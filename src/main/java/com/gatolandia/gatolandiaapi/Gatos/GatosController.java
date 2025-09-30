package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GatosController {

    private GatosRepository gatosService;

    public GatosController(GatosRepository gatosService) {
        this.gatosService = gatosService;
    }

    @GetMapping("gatos/exibir")
    public List<GatosModel> exibirGatos() {
        return gatosService.findAll();
    }

    @PostMapping("gatos/adicionar")
    public GatosModel adicionarGatos(@RequestBody GatosModel gatos) {
            return  gatosService.save(gatos);
    }

    @GetMapping("gatos/exibir/{id}")
    public GatosModel exibirGatosPorId(@PathVariable Long id) {
        return gatosService.findById(id).orElse(null);
        }

    @PutMapping("gatos/editar")
    public String editarGatos() {return "Editar Gato";}

    @DeleteMapping("gatos/excluirId")
    public String excluirGatosPorI() {return "Excluir Gato pelo ID";}

}
