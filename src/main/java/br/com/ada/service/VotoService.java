package br.com.ada.service;

import br.com.ada.entities.Voto;
import br.com.ada.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {


    private VotoRepository votoRepository;


    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public String registrarVoto(Voto voto) {

        votoRepository.save(voto);

        return "voto registrado com sucesso";

    }
}
