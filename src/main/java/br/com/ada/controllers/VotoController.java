package br.com.ada.controllers;

import br.com.ada.entities.Voto;
import br.com.ada.service.VotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotoController {


    private VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping("/voto")
    public ResponseEntity<String> registraVoto(@RequestBody Voto voto) {

        String resultado = votoService.registrarVoto(voto);

        return ResponseEntity.ok(resultado);

    }
}
