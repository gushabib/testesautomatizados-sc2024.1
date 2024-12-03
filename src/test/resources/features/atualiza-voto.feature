Feature: Atualiza voto

  Scenario: Deve atualizar um usuario registrado no banco ao enviar os dados corretamente
    Given o banco de dados deve estar limpo
    When eu cadastro um voto com nome "Test" e numero do candidato 9996
    And eu atualizo o voto com nome "Test" para o nome "Test1"
    Then o voto com nome "Test1" deve estar salvo no banco de dados
