Feature: Remove o voto

  Scenario: Deve deletar um usuario que foi registrado no banco de dados
    Given o banco de dados deve estar limpo
    When eu cadastro um voto com nome "Test" e numero do candidato 9996
    And eu removo do banco de dados o voto com nome "Test"
    Then o banco de dados nao deve conter mais o voto com nome "Test"
