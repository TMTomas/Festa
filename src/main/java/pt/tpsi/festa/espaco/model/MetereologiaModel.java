package pt.tpsi.festa.espaco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * This class Just save the data from the json that are given from the {@link MetereologiaRequest}
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
@Data
public class MetereologiaModel {

	// 1 - ATRIBUTOS

    private List<Weather> weather;

    @JsonProperty("main")
    private Main Temperatura;

	// 2 - CONSTRUTORES
    /**
     * Construtor padrão da classe MetereologiaModel.
     */
    public MetereologiaModel() {
		weather = new ArrayList<>();
    }

	public MetereologiaModel(List<Weather> weather, Main temperatura) {
		super();
		this.weather = weather;
		Temperatura = temperatura;
	}
	
	public MetereologiaModel(MetereologiaModel metereologiaModel) {
		this(metereologiaModel.getWeather(), metereologiaModel.getTemperatura());
	}
    // 3 - GETS E SETS

	/**
	 * This method will give the weather
	 * @return weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * This method will set the weather
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * This method will give the Object from type Main
	 * @return Temperature
	 */
	public Main getTemperatura() {
		return Temperatura;
	}

	// 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * Convert the class to a textual form
     */
    @Override
	public String toString() {
		return "MetereologiaModel [weather=" + weather + ", Temperatura=" + Temperatura + "]";
	}

	
}
