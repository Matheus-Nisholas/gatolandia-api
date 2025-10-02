package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GatosController {

    private final GatosService gatosService;

    public GatosController(GatosService gatosService) {
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
    public GatosModel exibirGatosPorId(@PathVariable long id) {
        return gatosService.exibirPorId(id);
        }

    @PutMapping("gatos/editar/{id}")
    public GatosModel editarGatos(@RequestBody GatosModel gatoAtualizado, @PathVariable long id) {
        return gatosService.editarGatos(gatoAtualizado, id);
    }

    @DeleteMapping("gatos/excluir/{id}")
    public void excluirGatosPorId(@PathVariable long id) {
      gatosService.excluirGatosPorId(id);
    }

}
