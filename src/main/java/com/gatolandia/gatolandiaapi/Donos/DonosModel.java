package com.gatolandia.gatolandiaapi.Donos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "endereco")
    private String endereco;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String celular;

    @Column(name = "possuiGatos")
    private boolean possuiGatos;

    @JsonIgnore
    @OneToMany(mappedBy = "donos")
    private List<GatosModel> listaGatos;

}
