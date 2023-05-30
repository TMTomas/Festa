package pt.tpsi.festa.espaco.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationPlus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestMetreologiaAndLocationTest {
    private static RequestMetreologiaAndLocation request;
    List<Location> listBase;
    List<LocationPlus> listPlus;
    @BeforeEach
    void setUp() {
        // String latitude, String longitude, String weather
        listBase = List.of(new Location("CMAS,Santarem", "1000", "20000", "cloudy"));
        listPlus = List.of(new LocationPlus("CMas,Santarem", "1000", "20000", "cloudy", 10,
        5, 10, "administrativo", " "));
    }

    @Test
    void pesquisarListBase(){
       request = Mockito.mock(RequestMetreologiaAndLocation.class);
        request.pesquisar("CMAS,Santarem");
       Mockito.when(request.getLocationListBase()).thenReturn(listBase);

       List<Location> result = request.getLocationListBase();
       assertEquals(listBase.get(0),result.get(0));
    }
    @Test
    void pesquisarListPlus(){
        request = Mockito.mock(RequestMetreologiaAndLocation.class);
        request.pesquisar("CMAS,Santarem");
        Mockito.when(request.getLocationListPlus()).thenReturn(listPlus);

        List<Location> result = request.getLocationListBase();
        assertEquals(listPlus.get(0),result.get(0));
    }
    @Test
    void selecionar() {
        request = Mockito.mock(RequestMetreologiaAndLocation.class);
        Mockito.when(request.selecionar(0)).thenReturn(listPlus.get(0));

        assertEquals(listPlus.get(0),request.selecionar(0));
    }

    @Test
    void selecionarPorNome() {
        request = Mockito.mock(RequestMetreologiaAndLocation.class);
        Mockito.when(request.selecionar("CMAS")).thenReturn(listPlus.get(0));

        Location result = request.selecionar("CMAS");
        assertEquals(listPlus.get(0),result);
    }


}