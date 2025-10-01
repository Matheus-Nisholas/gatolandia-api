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
    public String adicionarDonos() {return "Adicionar Dono";}

    @GetMapping("donos/exibirPorId")
    public DonosModel exibirDonosPorId(Long id) {
        return donosService.exibirDonoPorId(id);
    }

    @PutMapping("donos/editar")
    public String editarDonos() {return "Editar Dono";}

    @DeleteMapping("donos/excluirId")
    public void excluirDonosPorId(Long id) {
        donosService.deletarDonosPorId(id);
    }

}
