package com.gatolandia.gatolandiaapi.Donos;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DonosMapper {
    DonosModel toModel(DonosDTO dto);

    DonosDTO toDTO(DonosModel model);
}
