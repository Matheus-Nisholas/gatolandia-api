package com.gatolandia.gatolandiaapi.Gatos;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GatosMapper {

    GatosModel toModel(GatosDTO dto);

    GatosDTO toDTO(GatosModel model);
}