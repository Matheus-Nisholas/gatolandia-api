package com.gatolandia.gatolandiaapi.AtendimentosVeterinarios;

import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_atendimentos_veterinarios")
public class AtendimentoVeterinarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gato_id")
    private GatosModel gato;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada = LocalDate.now();

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GatosModel getGato() {
        return gato;
    }

    public void setGato(GatosModel gato) {
        this.gato = gato;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
}
