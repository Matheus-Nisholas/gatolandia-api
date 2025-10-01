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
}
