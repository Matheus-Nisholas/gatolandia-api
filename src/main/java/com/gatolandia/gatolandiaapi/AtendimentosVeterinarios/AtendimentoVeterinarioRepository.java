package com.gatolandia.gatolandiaapi.AtendimentosVeterinarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoVeterinarioRepository extends JpaRepository<AtendimentoVeterinarioModel, Long> {

    long countByDataSaidaIsNull();
}
