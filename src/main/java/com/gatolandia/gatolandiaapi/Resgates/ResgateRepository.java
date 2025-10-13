package com.gatolandia.gatolandiaapi.Resgates;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ResgateRepository extends JpaRepository<ResgateModel, Long> {

    long countByDataResgateAfter(LocalDate data);
}
