package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatosService {

    private GatosRepository gatosRepository;

    public GatosService(GatosRepository gatosRepository) {
        this.gatosRepository = gatosRepository;
    }

    public List<GatosModel>  listarGatos() {
        return gatosRepository.findAll();
    }


}
