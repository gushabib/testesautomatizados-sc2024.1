package br.com.ada.integracao;

import br.com.ada.entities.Voto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class VotoIntegracao {

    @Autowired
    TestRestTemplate restTemplate;


    @LocalServerPort
    int port;

    private String getUrl() {
        return "http://localhost:" + port + "/voto";
    }

    @Test
    @DisplayName("Deve registrar voto corretamente quando os dados forem enviados")
    void test01() {

        Voto voto = new Voto();
        voto.setNome("Voto1");
        voto.setNumeroCandidato(1l);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(getUrl(), voto, String.class);

        System.out.println(responseEntity.getBody());
        assertEquals("voto registrado com sucesso-1", responseEntity.getBody());


        //
    }


    @Test
    @DisplayName("Deve obter um voto registrado anteriormente pelo id")
    void test02() {

        Voto voto = new Voto();
        voto.setNome("Voto1");
        voto.setNumeroCandidato(1l);

        //quero obter um voto por id
        //quando eu registrar um objeto ele deve ser retornado para mim, pelo menos o id.

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(getUrl(), voto, String.class);

        assertEquals("voto registrado com sucesso-1", responseEntity.getBody());

        String[] stringArray = responseEntity.getBody().split("-");

        String id = stringArray[stringArray.length - 1];

        System.out.println("Id do voto: " + id);
        ResponseEntity<Voto> votoResponseEntity = restTemplate.getForEntity("/voto/" + id, Voto.class);

        Voto votoRecurado = votoResponseEntity.getBody();
        assertEquals("Voto1", votoRecurado.getNome());
    }

    @Test
    @DisplayName("Deve atualizar um usuario registrado no banco ao enviar os dados corretamente")
    void test03() {

        Voto voto = new Voto();
        voto.setNome("Voto1");
        voto.setNumeroCandidato(1l);


        ResponseEntity<String> responseEntity = restTemplate.postForEntity(getUrl(), voto, String.class);

        Voto atualizaVoto = new Voto();
        atualizaVoto.setNumeroCandidato(9999l);
        atualizaVoto.setNome("Test atualizado");


        restTemplate.put("/voto/1", atualizaVoto);



    }



}
