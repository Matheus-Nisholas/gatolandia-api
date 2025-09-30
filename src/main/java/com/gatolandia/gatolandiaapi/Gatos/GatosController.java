package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GatosController {

    private final GatosService gatosService;
    private GatosRepository gatosRepository;

    public GatosController(GatosRepository gatosRepository, GatosService gatosService) {
        this.gatosRepository = gatosRepository;
        this.gatosService = gatosService;
    }

    @GetMapping("gatos/exibir")
    public List<GatosModel> exibirGatos() {
        return gatosService.listarGatos();
    }

    @PostMapping("gatos/adicionar")
    public GatosModel adicionarGatos(@RequestBody GatosModel gatos) {
            return gatosService.adicionarGatos(gatos);
    }

    @GetMapping("gatos/exibir/{id}")
    public GatosModel exibirGatosPorId(@PathVariable Long id) {
        return gatosService.exibirPorId(id);
        }

    @PutMapping("gatos/editar")
    public String editarGatos() {return "Editar Gato";}

    @DeleteMapping("gatos/excluir/{id}")
    public void excluirGatosPorId(@PathVariable Long id) {
      gatosService.excluirGatosPorId(id);
    }

}
