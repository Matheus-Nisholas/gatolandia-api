package com.gatolandia.gatolandiaapi.Gatos;

import com.gatolandia.gatolandiaapi.Donos.DonosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatosDTO {

    private long id;
    private String nome;
    private String cor;
    private String raca;
    private int idade;
    private boolean castrado;
    private DonosModel donos;


}
