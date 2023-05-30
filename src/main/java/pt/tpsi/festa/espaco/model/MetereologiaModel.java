package pt.tpsi.festa.espaco.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
    private List<Weather> weather;

    /**
     * Objeto que representa a temperatura.
     */
    @JsonProperty("main")
    private Main Temperatura;

	// 2 - CONSTRUTORES
    /**
     * Construtor padrão da classe MetereologiaModel.
     */
    public MetereologiaModel() {
    }

	public MetereologiaModel(List<Weather> weather, Main temperatura) {
		super();
		weather = new ArrayList<>();
		this.weather = weather;
		Temperatura = temperatura;
	}
	
	public MetereologiaModel(MetereologiaModel metereologiaModel) {
		this(metereologiaModel.getWeather(), metereologiaModel.getTemperatura());
	}
    // 3 - GETS E SETS

    // já setado automaticamente devido a anotação Data
    
    // 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * metódo que faz uma apresentação textual da classe
     */
    @Override
	public String toString() {
		return "MetereologiaModel [weather=" + weather + ", Temperatura=" + Temperatura + "]";
	}

	
}
