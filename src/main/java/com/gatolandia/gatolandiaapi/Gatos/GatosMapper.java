package com.gatolandia.gatolandiaapi.Gatos;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GatosMapper {

    GatosModel toModel(GatosDTO dto);

    GatosDTO toDTO(GatosModel model);
}