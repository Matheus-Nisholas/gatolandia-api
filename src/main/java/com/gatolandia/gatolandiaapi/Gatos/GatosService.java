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

    public List<GatosDTO>  listarGatos() {
        List<GatosModel> gatos = gatosRepository.findAll();
        return gatos.stream()
                .map(gatosMapper::map)
                .collect(Collectors.toList());
    }

    public GatosDTO exibirPorId(long id) {
        Optional<GatosModel> exibirPorId = gatosRepository.findById(id);
        return exibirPorId.map(gatosMapper::map).orElse(null);
    }

    public GatosDTO adicionarGatos(GatosDTO gatosDTO) {
        GatosModel gato = new GatosMapper().map(gatosDTO);
        gato = gatosRepository.save(gato);
        return gatosMapper.map(gato);
    }

    public void excluirGatosPorId(long id) {
      gatosRepository.deleteById(id);
    }

    public GatosDTO editarGatos(GatosDTO gatoAtualizado, Long id) {
        Optional<GatosModel> gatosExistentes = gatosRepository.findById(id);
        if (gatosExistentes.isPresent()) {
            GatosModel gatosEditado = gatosMapper.map(gatoAtualizado);
            gatosEditado.setId(id);
            gatosEditado = gatosRepository.save(gatosEditado);
            return gatosMapper.map(gatosEditado);
        }
        return null;
    }

}
