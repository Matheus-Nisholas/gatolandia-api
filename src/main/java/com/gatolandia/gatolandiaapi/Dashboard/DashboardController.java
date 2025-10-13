package com.gatolandia.gatolandiaapi.Dashboard;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@Tag(name = "Dashboard", description = "Endpoints para consultar indicadores do painel principal")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/resumo")
    @Operation(summary = "Obtém o resumo dos principais indicadores exibidos no painel")
    public ResponseEntity<DashboardOverviewDTO> obterResumoDashboard() {
        return ResponseEntity.ok(dashboardService.obterResumoDashboard());
    }
}
