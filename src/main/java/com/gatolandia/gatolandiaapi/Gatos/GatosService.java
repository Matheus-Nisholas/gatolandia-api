package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class GatosService {

    private GatosRepository gatosRepository;

    public GatosService(GatosRepository gatosRepository) {
        this.gatosRepository = gatosRepository;
    }

    public List<GatosModel>  listarGatos() {
        return gatosRepository.findAll();
    }

    public GatosModel exibirPorId(long id) {
        Optional<GatosModel> exibirPorId = gatosRepository.findById(id);
        return exibirPorId.orElse(null);
    }

}
