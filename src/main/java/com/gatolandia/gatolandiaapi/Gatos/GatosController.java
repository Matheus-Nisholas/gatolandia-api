package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<GatosDTO> exibirGatos() {
        return gatosService.listarGatos();
    }

    @PostMapping("gatos/adicionar")
    public ResponseEntity<String> adicionarGatos(@RequestBody GatosDTO gatos) {
        GatosDTO gatoNovo = gatosService.adicionarGatos(gatos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Gato adicionado com sucesso!");
    }

    @GetMapping("gatos/exibir/{id}")
    public GatosDTO exibirGatosPorId(@PathVariable long id) {
        return gatosService.exibirPorId(id);
    }

    @PutMapping("gatos/editar/{id}")
    public GatosDTO editarGatos(@RequestBody GatosDTO gatoAtualizado, @PathVariable long id) {
        return gatosService.editarGatos(gatoAtualizado, id);
    }

    @DeleteMapping("gatos/excluir/{id}")
    public void excluirGatosPorId(@PathVariable long id) {
        gatosService.excluirGatosPorId(id);
    }

}
