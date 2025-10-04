package com.gatolandia.gatolandiaapi.Gatos;

import com.gatolandia.gatolandiaapi.Donos.DonosDTO;
import com.gatolandia.gatolandiaapi.Donos.DonosModel;

public class GatosMapper {

    public GatosModel map(GatosDTO gatosDTO) {
        GatosModel gatosModel = new GatosModel();
        gatosModel.setId(gatosDTO.getId());
        gatosModel.setNome(gatosDTO.getNome());
        gatosModel.setCor(gatosDTO.getCor());
        gatosModel.setCor(gatosDTO.getCor());
        gatosModel.setRaca(gatosDTO.getRaca());
        gatosModel.setCastrado(gatosDTO.isCastrado());

        return gatosModel;
    }

    public GatosDTO map(GatosModel gatosModel) {
        GatosDTO gatosDTO = new GatosDTO();
        gatosDTO.setId(gatosModel.getId());
        gatosDTO.setNome(gatosModel.getNome());
        gatosDTO.setCor(gatosModel.getCor());
        gatosDTO.setCor(gatosModel.getCor());
        gatosDTO.setRaca(gatosModel.getRaca());
        gatosDTO.setCastrado(gatosModel.isCastrado());

        return gatosDTO;
    }
}
