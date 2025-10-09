package com.gatolandia.gatolandiaapi.Donos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonosDTO {

    private long id;
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private String celular;
    private boolean possuiGatos;
    private List<GatosModel> listaGatos;

}
