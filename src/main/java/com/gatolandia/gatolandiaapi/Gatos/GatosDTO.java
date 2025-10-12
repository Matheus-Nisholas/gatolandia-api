package com.gatolandia.gatolandiaapi.Gatos;

import com.gatolandia.gatolandiaapi.Donos.DonosModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação de um gato na API")
public class GatosDTO {

    @Schema(description = "Identificador único do gato", example = "1")
    private long id;

    @Schema(description = "Nome do gato", example = "Mingau")
    private String nome;

    @Schema(description = "Cor predominante do gato", example = "Branco")
    private String cor;

    @Schema(description = "Raça do gato", example = "Siamês")
    private String raca;

    @Schema(description = "Idade aproximada do gato", example = "3")
    private int idade;

    @Schema(description = "Indica se o gato é castrado")
    private boolean castrado;

    @Schema(description = "Dono associado ao gato")
    private DonosModel donos;

}
