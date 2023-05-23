package pt.tpsi.festa.espaco.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.tpsi.festa.espaco.model.Location;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestMetreologiaAndLocationTest {
    // TODO Fazer os testes
    //Criar um mockito para listas
    private final RequestMetreologiaAndLocation request = new RequestMetreologiaAndLocation();
    @BeforeAll
    void setUp() {
        List<Location> list = new ArrayList<>();
    }

    @Test
    void pesquisar(){
        request.pesquisar("CNEMA, Santarem");
    }
    @Test
    void selecionar() {
        for(int i = 0; i < request.getLocationList().size(); i++){
            assertEquals(request, request.selecionar(i));
        }
    }

    @Test
    void selecionarPorNome() {
        assertEquals("cnema",request.selecionarPorNome("Cnema"));
    }


}