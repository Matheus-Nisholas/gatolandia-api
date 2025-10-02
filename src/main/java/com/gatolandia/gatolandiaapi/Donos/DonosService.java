package com.gatolandia.gatolandiaapi.Donos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonosService {

    private DonosRepository donosRepository;

    public DonosService(DonosRepository donosRepository) {
        this.donosRepository = donosRepository;
    }

    public List<DonosModel> exibirDonos(){
         return donosRepository.findAll();
    }

    public DonosModel exibirDonoPorId(long id){
        return donosRepository.findById(id).orElse(null);
    }

    public void deletarDonosPorId(long id){
        donosRepository.deleteById(id);
    }

    public DonosModel adicionarDonos(DonosModel donosModel){
        return donosRepository.save(donosModel);
    }

    public DonosModel editarDono(DonosModel donoAtualizado, long id){
    if (donosRepository.existsById(id)){
        donoAtualizado.setId(id);
        return donosRepository.save(donoAtualizado);
    } else {
        return null;}
    }
}
