package com.gatolandia.gatolandiaapi.Gatos;

import com.gatolandia.gatolandiaapi.Donos.DonosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_gatos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cor;

    private String raca;

    private int idade;

    private boolean castrado;

    @ManyToOne
    @JoinColumn(name = "tb_donos_id")
    private DonosModel donos;

}

