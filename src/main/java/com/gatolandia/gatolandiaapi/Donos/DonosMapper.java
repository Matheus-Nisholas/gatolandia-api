package com.gatolandia.gatolandiaapi.Donos;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DonosMapper {
    DonosModel toModel(DonosDTO dto);

    DonosDTO toDTO(DonosModel model);
}
