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
    public List<DonosModel> exibirDonos() {
        return donosService.exibirDonos();
    }

    @PostMapping("donos/adicionar")
    public DonosModel adicionarDonos(@RequestBody DonosModel donosModel) {
        return donosService.adicionarDonos(donosModel);
    }

    @GetMapping("donos/exibir/{id}")
    public DonosModel exibirDonosPorId(@PathVariable Long id) {
        return donosService.exibirDonoPorId(id);
    }

    @PutMapping("donos/editar")
    public String editarDonos() {return "Editar Dono";}

    @DeleteMapping("donos/excluir/{id}")
    public void excluirDonosPorId(@PathVariable Long id) {
        donosService.deletarDonosPorId(id);
    }

}
