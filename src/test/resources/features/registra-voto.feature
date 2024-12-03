Feature: Registro de voto

  Scenario: Deve registrar voto corretamente quando os dados forem enviados
    Given o banco de dados deve estar limpo
    When eu cadastro um voto com nome "Test" e numero do candidato 9996
    Then o voto com nome "Test" deve estar salvo no banco de dados
