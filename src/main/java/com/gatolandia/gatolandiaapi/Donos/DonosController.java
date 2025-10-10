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
    public ResponseEntity<List<DonosDTO>> exibirDonos() {
        List<DonosDTO> donos = donosService.listarDonos();
        return ResponseEntity.status(HttpStatus.OK).body(donos);
    }

    @GetMapping("donos/exibir/{id}")
    public ResponseEntity<?> exibirDonosPorId(@PathVariable long id) {
        DonosDTO dono = donosService.exibirPorId(id);
        if (dono != null) {
            return ResponseEntity.ok().body(dono);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum dono encontrado!");
        }
    }

    @PostMapping("donos/adicionar")
    public ResponseEntity<String> adicionarDonos(@RequestBody DonosDTO donosDTO) {
        DonosDTO adicionarDonos = donosService.adicionarDonos(donosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dono adicionado com sucesso!");
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
