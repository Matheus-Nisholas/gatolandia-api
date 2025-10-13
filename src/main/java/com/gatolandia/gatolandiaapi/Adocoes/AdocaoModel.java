package com.gatolandia.gatolandiaapi.Adocoes;

import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_adocoes")
public class AdocaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "gato_id")
    private GatosModel gato;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAdocao status = StatusAdocao.EM_ANDAMENTO;

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

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusAdocao getStatus() {
        return status;
    }

    public void setStatus(StatusAdocao status) {
        this.status = status;
    }
}
