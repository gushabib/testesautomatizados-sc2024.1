package br.com.ada.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {


    public int soma(int a, int b) {

        //assert expressao_booleana: "Numero inválido"
        //Lanca um AssertionError se a expressao booleana for falsa
        if (a <= 0 || b <= 0) throw new AssertionError("Entrada inválida");

        return a + b;
    }


}
