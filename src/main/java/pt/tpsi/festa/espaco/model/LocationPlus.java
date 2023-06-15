package pt.tpsi.festa.espaco.model;

import lombok.Data;

/**
 * This class serves to create a structure for the list with the important data with more data
 * than the class {@link Location}
 *
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 *
 */

@Data
public class LocationPlus extends Location {

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
     * @param nameLocation from the location
     * @param latitude from the location
     * @param longitude from the location
     * @param weather from the location
     * @param temperature from the location
     * @param temperatureMin from the location
     * @param temperatureMax from the location
     * @param type from the location
     * @param icon from the location
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
    /**
     * Construtor clone da classe, que recebe um objeto do mesmo tipo
     * @param locationPlus an objecto of type LocationpPlus
     */
    public LocationPlus(LocationPlus locationPlus) {
    	this(locationPlus.getNameLocation(), locationPlus.getLatitude(), locationPlus.getLongitude(),
    			locationPlus.getWeather(), locationPlus.getTemperature(), locationPlus.getTemperatureMin(), locationPlus.getTemperatureMax(), locationPlus.getType(), locationPlus.getIcon());
    }
    // 3 - gets e sets

	/**
	 * This method will give the temperature
	 * @return temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * This method will give the temperature Minimum
	 * @return temperatureMin
	 */
	public double getTemperatureMin() {
		return temperatureMin;
	}

	/**
	 * This method will give the temperature Max
	 * @return temperatureMax
	 */
	public double getTemperatureMax() {
		return temperatureMax;
	}

	/**
	 * This method will give the type
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method will give the icon
	 * @return icon
	 */
	public String getIcon() {
		return icon;
	}


	// 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * Convert the class to a textual form
     */
	@Override
	public String toString() {
		return "LocationPlus{" +
				"name='"+getNameLocation()+'\'' +
				" latitude='"+getLatitude()+'\'' +
				" longitude='"+getLongitude()+'\'' +
				" weather='"+getWeather()+'\'' +
				" temperature='" + temperature +'\'' +
				" temperatureMin='" + temperatureMin +'\'' +
				" temperatureMax='" + temperatureMax +'\'' +
				" type='" + type + '\'' +
				" icon='" + icon + '\'' +
				'}';
	}
}
