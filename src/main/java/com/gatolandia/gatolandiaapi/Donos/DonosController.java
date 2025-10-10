package com.gatolandia.gatolandiaapi.Donos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DonosController {

    private final DonosService donosService;

    public DonosController(DonosService donosService) {
        this.donosService = donosService;
    }

    @GetMapping("donos/exibir")
    public List<DonosDTO> exibirDonos() {
        return donosService.listarDonos();
    }

    @PostMapping("donos/adicionar")
    public ResponseEntity<String> adicionarDonos(@RequestBody DonosDTO donosDTO) {
        DonosDTO adicionarDonos = donosService.adicionarDonos(donosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dono adicionado com sucesso!");
    }

    @GetMapping("donos/exibir/{id}")
    public DonosDTO exibirDonosPorId(@PathVariable long id) {
        return donosService.exibirPorId(id);
    }

    @PutMapping("donos/editar/{id}")
    public ResponseEntity<String> editarDonos(@RequestBody DonosDTO donoAtualizado, @PathVariable long id) {
        if (donosService.exibirPorId(id) != null) {
            DonosDTO donosDTO = donosService.editarDonos(donoAtualizado, id);
            return  ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Donos atualizado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dono não encontrado!");
        }
    }

    @DeleteMapping("donos/excluir/{id}")
    public ResponseEntity<String> excluirDonosPorId(@PathVariable long id) {
        if (donosService.exibirPorId(id) != null) {
            donosService.excluirDonosPorId(id);
            return ResponseEntity.ok("Dono de (ID)"+id+" excluido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Dono não encontrado!");
        }
    }
}
