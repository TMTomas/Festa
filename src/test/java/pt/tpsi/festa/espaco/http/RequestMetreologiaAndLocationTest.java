package pt.tpsi.festa.espaco.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.tpsi.festa.espaco.model.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestMetreologiaAndLocationTest {
    private static RequestMetreologiaAndLocation request;
    List<Location> list;
    @BeforeEach
    void setUp() {
        // String latitude, String longitude, String weather
        list = List.of(new Location("CMAS,Santarem", "1000", "20000", "cloudy"));

    }

    @Test
    void pesquisar(){
       request = Mockito.mock(RequestMetreologiaAndLocation.class);
       Mockito.when(request.pesquisar("CMAS,Santarem")).thenReturn(list);

       List<Location> result = request.pesquisar("CMAS,Santarem");
       assertEquals(list.get(0),result.get(0));
    }
    @Test
    void selecionar() {
        request = Mockito.mock(RequestMetreologiaAndLocation.class);
        Mockito.when(request.selecionar(0)).thenReturn(list.get(0));

        assertEquals(list.get(0),request.selecionar(0));
    }

    @Test
    void selecionarPorNome() {
        request = Mockito.mock(RequestMetreologiaAndLocation.class);
        Mockito.when(request.selecionarPorNome("CMAS")).thenReturn(list.get(0));

        Location result = request.selecionarPorNome("CMAS");
        assertEquals(list.get(0),result);
    }


}