package pt.tpsi.festa.espaco.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um modelo de dados para informações meteorológicas.
 */

@Data
public class MetereologiaModel {

	// 1 - ATRIBUTOS
	 /**
     * Lista de informações meteorológicas.
     */
    private ArrayList<Weather> weather;
    /**
     * Objeto que representa a temperatura.
     */
    private Temperatura temperatura;
	// 2 - CONSTRUTORES
    /**
     * Construtor padrão da classe MetereologiaModel.
     */
    public MetereologiaModel() {
    }

    // 3 - GETS E SETS
    /**
     * Obtém a lista de informações meteorológicas.
     *
     * @return A lista de informações meteorológicas.
     */
    public ArrayList<Weather> getWeather() {
        return weather;
    }
    /**
     * Obtém o objeto de temperatura.
     *
     * @return O objeto de temperatura.
     */
    public Temperatura getTemperatura() {
        return temperatura;
    }

    // 4 - COMPORTAMENTOS

	// 5 - METODOS COMPLEMENTARES

}
