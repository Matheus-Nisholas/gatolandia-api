package com.gatolandia.gatolandiaapi.Gatos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GatosService {

    private GatosMapper gatosMapper;
    private GatosRepository gatosRepository;

    public GatosService(GatosMapper gatosMapper, GatosRepository gatosRepository) {
        this.gatosMapper = gatosMapper;
        this.gatosRepository = gatosRepository;
    }

    public List<GatosDTO> listarGatos() {
        List<GatosModel> gatos = gatosRepository.findAll();
        return gatos.stream()
                .map(gatosMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GatosDTO exibirPorId(long id) {
        Optional<GatosModel> exibirPorId = gatosRepository.findById(id);
        return exibirPorId.map(gatosMapper::toDTO).orElse(null);
    }

    public GatosDTO adicionarGatos(GatosDTO gatosDTO) {

        GatosModel gato = gatosMapper.toModel(gatosDTO);
        gato = gatosRepository.save(gato);
        return gatosMapper.toDTO(gato);
    }

    public boolean excluirGatosPorId(long id) {
        Optional<GatosModel> gatoExistente = gatosRepository.findById(id);
        if (gatoExistente.isPresent()) {
            gatosRepository.delete(gatoExistente.get());
            return true;
        }
        return false;
    }

    public GatosDTO editarGatos(GatosDTO gatoDTO, Long id) {
        Optional<GatosModel> gatosExistentes = gatosRepository.findById(id);
        if (gatosExistentes.isPresent()) {
            GatosModel gatosEditado = gatosMapper.toModel(gatoDTO);
            gatosEditado.setId(id);
            gatosEditado = gatosRepository.save(gatosEditado);
            return gatosMapper.toDTO(gatosEditado);
        }
        return null;
    }

}
