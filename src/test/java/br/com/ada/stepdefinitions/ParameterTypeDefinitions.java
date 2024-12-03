package br.com.ada.stepdefinitions;
import io.cucumber.java.ParameterType;

public class ParameterTypeDefinitions {


    //@ParameterType(".*")
    public String nome(String nome) {
        return nome;
    }

    //@ParameterType("//d+")
    public Long numeroDoCandidato(String numeroDoCandidato) {
        return Long.parseLong(numeroDoCandidato);
    }
    
}
