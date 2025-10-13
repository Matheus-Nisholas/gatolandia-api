package com.gatolandia.gatolandiaapi.Dashboard;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resumo de indicadores exibidos no painel principal da aplicação")
public class DashboardOverviewDTO {

    @Schema(description = "Total arrecadado em doações", example = "12450.00")
    private BigDecimal totalArrecadado;

    @Schema(description = "Quantidade total de adoções concluídas", example = "24")
    private long adocoesConcluidas;

    @Schema(description = "Quantidade de resgates realizados nos últimos 30 dias", example = "5")
    private long resgatesRecentes;

    @Schema(description = "Quantidade de gatos atualmente em atendimento veterinário", example = "3")
    private long gatosNoVeterinario;

    @Schema(description = "Quantidade total de gatos acolhidos", example = "38")
    private long totalGatosAcolhidos;

    @Schema(description = "Quantidade de gatos aguardando adoção", example = "7")
    private long gatosAguardando;

    @Schema(description = "Quantidade de gatos atualmente em tratamento", example = "12")
    private long gatosEmTratamento;

    @Schema(description = "Quantidade de gatos adotados", example = "19")
    private long gatosAdotados;

    public DashboardOverviewDTO(BigDecimal totalArrecadado, long adocoesConcluidas, long resgatesRecentes,
                                 long gatosNoVeterinario, long totalGatosAcolhidos, long gatosAguardando,
                                 long gatosEmTratamento, long gatosAdotados) {
        this.totalArrecadado = totalArrecadado;
        this.adocoesConcluidas = adocoesConcluidas;
        this.resgatesRecentes = resgatesRecentes;
        this.gatosNoVeterinario = gatosNoVeterinario;
        this.totalGatosAcolhidos = totalGatosAcolhidos;
        this.gatosAguardando = gatosAguardando;
        this.gatosEmTratamento = gatosEmTratamento;
        this.gatosAdotados = gatosAdotados;
    }

    public BigDecimal getTotalArrecadado() {
        return totalArrecadado;
    }

    public long getAdocoesConcluidas() {
        return adocoesConcluidas;
    }

    public long getResgatesRecentes() {
        return resgatesRecentes;
    }

    public long getGatosNoVeterinario() {
        return gatosNoVeterinario;
    }

    public long getTotalGatosAcolhidos() {
        return totalGatosAcolhidos;
    }

    public long getGatosAguardando() {
        return gatosAguardando;
    }

    public long getGatosEmTratamento() {
        return gatosEmTratamento;
    }

    public long getGatosAdotados() {
        return gatosAdotados;
    }
}
