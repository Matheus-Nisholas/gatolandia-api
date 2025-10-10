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
    public ResponseEntity<String> editarGatos(@RequestBody GatosDTO gatoAtualizado, @PathVariable long id) {
        GatosDTO editarGatos = gatosService.editarGatos(gatoAtualizado, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gato atualizado com sucesso!");
    }

    @DeleteMapping("gatos/excluir/{id}")
    public ResponseEntity<String> excluirGatosPorId(@PathVariable long id) {
        gatosService.excluirGatosPorId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Gato excluido com sucesso!");
    }

}
