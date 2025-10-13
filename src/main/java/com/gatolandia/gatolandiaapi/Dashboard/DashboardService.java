package com.gatolandia.gatolandiaapi.Dashboard;

import com.gatolandia.gatolandiaapi.Adocoes.AdocaoRepository;
import com.gatolandia.gatolandiaapi.Adocoes.StatusAdocao;
import com.gatolandia.gatolandiaapi.AtendimentosVeterinarios.AtendimentoVeterinarioRepository;
import com.gatolandia.gatolandiaapi.Doacoes.DoacaoRepository;
import com.gatolandia.gatolandiaapi.Gatos.GatosRepository;
import com.gatolandia.gatolandiaapi.Gatos.StatusAcolhimento;
import com.gatolandia.gatolandiaapi.Resgates.ResgateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DashboardService {

    private final DoacaoRepository doacaoRepository;
    private final AdocaoRepository adocaoRepository;
    private final ResgateRepository resgateRepository;
    private final AtendimentoVeterinarioRepository atendimentoVeterinarioRepository;
    private final GatosRepository gatosRepository;

    public DashboardService(DoacaoRepository doacaoRepository,
                             AdocaoRepository adocaoRepository,
                             ResgateRepository resgateRepository,
                             AtendimentoVeterinarioRepository atendimentoVeterinarioRepository,
                             GatosRepository gatosRepository) {
        this.doacaoRepository = doacaoRepository;
        this.adocaoRepository = adocaoRepository;
        this.resgateRepository = resgateRepository;
        this.atendimentoVeterinarioRepository = atendimentoVeterinarioRepository;
        this.gatosRepository = gatosRepository;
    }

    public DashboardOverviewDTO obterResumoDashboard() {
        BigDecimal totalArrecadado = doacaoRepository.obterTotalArrecadado();
        long adocoesConcluidas = adocaoRepository.countByStatus(StatusAdocao.CONCLUIDA);
        long resgatesRecentes = resgateRepository.countByDataResgateAfter(LocalDate.now().minusDays(30));
        long gatosNoVeterinario = atendimentoVeterinarioRepository.countByDataSaidaIsNull();

        long gatosAguardando = gatosRepository.countByStatusAcolhimento(StatusAcolhimento.AGUARDANDO);
        long gatosEmTratamento = gatosRepository.countByStatusAcolhimento(StatusAcolhimento.EM_TRATAMENTO);
        long gatosAdotados = gatosRepository.countByStatusAcolhimento(StatusAcolhimento.ADOTADO);
        long totalGatos = gatosAguardando + gatosEmTratamento + gatosAdotados;

        return new DashboardOverviewDTO(totalArrecadado,
                adocoesConcluidas,
                resgatesRecentes,
                gatosNoVeterinario,
                totalGatos,
                gatosAguardando,
                gatosEmTratamento,
                gatosAdotados);
    }
}
