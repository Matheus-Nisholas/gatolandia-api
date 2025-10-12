package com.gatolandia.gatolandiaapi.Donos;

import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação de um dono na API")
public class DonosDTO {

    @Schema(description = "Identificador único do dono", example = "1")
    private long id;

    @Schema(description = "Nome completo do dono", example = "Maria Silva")
    private String nome;

    @Schema(description = "Idade do dono", example = "28")
    private int idade;

    @Schema(description = "Endereço residencial", example = "Rua dos Gatos, 100 - Centro")
    private String endereco;

    @Schema(description = "E-mail para contato", example = "maria.silva@email.com")
    private String email;

    @Schema(description = "Número de telefone", example = "+55 11 99999-9999")
    private String celular;

    @Schema(description = "Indica se o dono possui gatos cadastrados")
    private boolean possuiGatos;

    @Schema(description = "Lista de gatos associados ao dono")
    private List<GatosModel> listaGatos;

}
