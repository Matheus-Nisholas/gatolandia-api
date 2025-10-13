package com.gatolandia.gatolandiaapi.Adocoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<AdocaoModel, Long> {

    long countByStatus(StatusAdocao status);
}
