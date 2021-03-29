@tc1
Feature:  usuario está na tela de cadastro

  Background:
    Given acessar pagina inicial

  Scenario: Sort e search na tabela
    Given usuario acessa a tela de table sort e search
    When busca um empregado usando a palavra "London"
    Then a tabela é filtrada
