package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class LocationPlus extends Location{
   
	// 1 - atributos
	/**
	 * atributos da classe são os que definimos a baixo
	 * além dos atributos da classe extendida
	 * temperature para a temperatuda da Location
	 * temperatureMin da Location
	 * temperatureMax da Location
	 */
    private double temperature;
    private double temperatureMin;
    private double temperatureMax;
    private String type;
    private String icon;
    
    // 2 - construtores 
	/**
	 * Construtor default da classe LocationPlus
	 */
    public LocationPlus() {
	}
    /**
     * Construtor com paramentros da classe LocationPlus
     * @param nameLocation
     * @param latitude
     * @param longitude
     * @param weather
     * @param temperature
     * @param temperatureMin
     * @param temperatureMax
     * @param type
     * @param icon
     */
    public LocationPlus(String nameLocation, String latitude, String longitude, String weather, double temperature,
			double temperatureMin, double temperatureMax, String type, String icon) {
		super(nameLocation, latitude, longitude, weather);
		this.temperature = temperature;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.type = type;
		this.icon = icon;
	}

    // 3 - gets e sets
    // a anotação Data serve para os gets e sets desta classe
    // 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * Metódo que representa a classe de forma escrita 
     */
    @Override
    public String toString() {
        return "LocationPlus{" +
                ", temperature=" + temperature +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                '}';
   }
}
