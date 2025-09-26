package com.gatolandia.gatolandiaapi.Donos;

import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonosRepository extends JpaRepository<DonosModel, Long> {
}
