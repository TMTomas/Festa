package pt.tpsi.festa.espaco.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MetereologiaModel {

	// 1 - ATRIBUTOS
    private ArrayList<Weather> weather;
    private Temperatura temperatura;

	// 2 - CONSTRUTORES

    public MetereologiaModel() {
    }

    // 3 - GETS E SETS

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    // 4 - COMPORTAMENTOS

	// 5 - METODOS COMPLEMENTARES

}
