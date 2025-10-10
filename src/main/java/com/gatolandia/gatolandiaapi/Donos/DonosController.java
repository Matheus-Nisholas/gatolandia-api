package com.gatolandia.gatolandiaapi.Donos;

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
    public DonosDTO adicionarDonos(@RequestBody DonosDTO donosDTO) {
        return donosService.adicionarDonos(donosDTO);
    }

    @GetMapping("donos/exibir/{id}")
    public DonosDTO exibirDonosPorId(@PathVariable long id) {
        return donosService.exibirPorId(id);
    }

    @PutMapping("donos/editar/{id}")
    public DonosDTO editarDonos(@RequestBody DonosDTO donoAtualizado, @PathVariable long id) {
        return donosService.editarDonos(donoAtualizado, id);
    }

    @DeleteMapping("donos/excluir/{id}")
    public void excluirDonosPorId(@PathVariable long id) {
        donosService.excluirDonosPorId(id);
    }
}
