package br.com.ada.stepdefinitions;

import br.com.ada.entities.Voto;
import br.com.ada.repository.VotoRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@CucumberContextConfiguration
@DataJpaTest
public class DefinicaoDePassos {

    @Autowired
    VotoRepository votoRepository;


    @Given("o banco de dados deve estar limpo")
    public void oBancoDeDadosEstaLimpo() {

        votoRepository.deleteAll();
    }

//    @When("eu cadastro um voto com nome {nome} e numero do candidato {numeroCandidato}")
//    public void euCadastroUmVotoComNomeENumeroDoCandidato(String nome, Long numeroCandidato) {
//        Voto voto = new Voto();
//        voto.setNome(nome);
//        voto.setNumeroCandidato(numeroCandidato);
//
//        votoRepository.save(voto);
//    }


    @Then("o voto com nome {string} deve estar salvo no banco de dados")
    public void oVotoComNomeDeveEstarSalvoNoBancoDeDados(String nome) {
        Optional<Voto> votoOptional =
                votoRepository.findById(1l);

        Voto voto = votoOptional.get();

        assertEquals(nome, voto.getNome());
    }


    @When("eu cadastro um voto com nome {string} e numero do candidato {int}")
    public void euCadastroUmVotoComNomeENumeroDoCandidato(String nome, int numeroCandidato) {
        Voto voto = new Voto();
        voto.setNome(nome);
        voto.setNumeroCandidato((long)numeroCandidato);

        votoRepository.save(voto);
    }


    @And("eu atualizo o voto com nome {string} para o nome {string}")
    public void euAtualizoOVotoComNomeParaONome(String arg0, String nomeVotoAtualizado) {

        Optional<Voto> votoOptional = votoRepository.findById(1l);
        Voto voto = votoOptional.get();

        voto.setNome(nomeVotoAtualizado);

        votoRepository.save(voto);

    }

    @And("eu removo do banco de dados o voto com nome {string}")
    public void euRemovoDoBancoDeDadosOVotoComNome(String nome) {

        Optional<Voto> votoOptional = votoRepository.findByNome(nome);

        if (votoOptional.isPresent()) {
            votoRepository.deleteById(votoOptional.get().getId());
        }

    }

    @Then("o banco de dados nao deve conter mais o voto com nome {string}")
    public void oBancoDeDadosNaoDeveConterMaisOVotoComNome(String nome) {

        Optional<Voto> votoOptional = votoRepository.findByNome(nome);

        assertTrue(votoOptional.isEmpty());

    }
}
