package br.com.ada.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {


    private CalculadoraService calculadoraService = new CalculadoraService();


    @Test
    @DisplayName("Dado dois numeros inteiros somar e obter o resultado correto")
    void test1() {

        int resultado = calculadoraService.soma(1, 2);

        assertEquals(3, resultado);

    }

    @Test
    @DisplayName("Dado dois numeros negativos deve lancar um AssertionError")
    void test2() {

        AssertionError assertionError = assertThrows(AssertionError.class, () -> calculadoraService.soma(-1, -2));

        assertEquals("Entrada inválida",assertionError.getMessage());
    }

}
