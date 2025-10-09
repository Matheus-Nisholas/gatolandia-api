package com.gatolandia.gatolandiaapi.Donos;

import com.gatolandia.gatolandiaapi.Gatos.GatosDTO;
import com.gatolandia.gatolandiaapi.Gatos.GatosModel;
import com.gatolandia.gatolandiaapi.Gatos.GatosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonosService {

    private DonosMapper donosMapper;
    private DonosRepository donosRepository;

    public DonosService(DonosRepository donosRepository, DonosMapper donosMapper) {
        this.donosRepository = donosRepository;
        this.donosMapper = donosMapper;
    }

    public List<DonosDTO>  listarDonos() {
        List<DonosModel> gatos = donosRepository.findAll();
        return gatos.stream()
                .map(donosMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DonosDTO exibirPorId(long id) {
        Optional<DonosModel> exibirPorId = donosRepository.findById(id);
        return exibirPorId.map(donosMapper::toDTO).orElse(null);
    }

    public DonosDTO adicionarDonos(DonosDTO donosDTO) {

        DonosModel dono = donosMapper.toModel(donosDTO);
        dono = donosRepository.save(dono);
        return donosMapper.toDTO(dono);
    }

    public void excluirDonosPorId(long id) {
        donosRepository.deleteById(id);
    }

    public DonosDTO editarDonos(DonosDTO donosDTO, Long id) {
        Optional<DonosModel> donosExistentes = donosRepository.findById(id);
        if (donosExistentes.isPresent()) {
            DonosModel donosEditado = donosMapper.toModel(donosDTO);
            donosEditado.setId(id);
            donosEditado = donosRepository.save(donosEditado);
            return donosMapper.toDTO(donosEditado);
        }
        return null;
    }

}
