package com.gatolandia.gatolandiaapi.Doacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Long> {

    @Query("SELECT COALESCE(SUM(d.valor), 0) FROM DoacaoModel d")
    BigDecimal obterTotalArrecadado();
}
