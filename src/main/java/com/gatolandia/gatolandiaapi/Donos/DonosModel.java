package com.gatolandia.gatolandiaapi.Donos;

import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_donos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private int idade;

    private String endereco;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String celular;

    private boolean possuiGatos;

    @OneToMany(mappedBy = "donos")
    private List <GatosModel> listaGatos;

}
