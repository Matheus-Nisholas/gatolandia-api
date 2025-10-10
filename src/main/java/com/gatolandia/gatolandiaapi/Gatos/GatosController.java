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
    public ResponseEntity<List<GatosDTO>> exibirGatos() {
        List<GatosDTO> gatos = gatosService.listarGatos();
        return ResponseEntity.status(HttpStatus.OK).body(gatos);
    }

    @GetMapping("gatos/exibir/{id}")
    public ResponseEntity<String> exibirGatosPorId(@PathVariable long id) {
        GatosDTO gatos = gatosService.exibirPorId(id);
        if (gatos != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Gatos exibido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Gatos encontrado");
        }
    }

    @PostMapping("gatos/adicionar")
    public ResponseEntity<String> adicionarGatos(@RequestBody GatosDTO gatos) {
        GatosDTO gatoNovo = gatosService.adicionarGatos(gatos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Gato adicionado com sucesso!");
    }

    @PutMapping("gatos/editar/{id}")
    public ResponseEntity<String> editarGatos(@RequestBody GatosDTO gatoAtualizado, @PathVariable long id) {
        if (gatosService.exibirPorId(id) != null) {
            GatosDTO gatosDTO = gatosService.editarGatos(gatoAtualizado, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Gato atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Gato não encontrado!");
        }
    }

    @DeleteMapping("gatos/excluir/{id}")
    public ResponseEntity<String> excluirGatosPorId(@PathVariable long id) {
        if (gatosService.exibirPorId(id) != null) {
            gatosService.excluirGatosPorId(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Gato excluido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Gato não encontrado!");
        }
    }

}
