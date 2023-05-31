package pt.tpsi.festa.espaco.model;

import lombok.Data;
/**
 * This class serves to create a structure for the list with the important data
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
@Data
public class Location {
	
	// 1 - atributos
    private String nameLocation;
    private String latitude;
    private String longitude;
    private String weather;

    // 2 - construtores
    /**
     * constructor default from classe Location
     */
    public Location() {
    }
    /**
     * constructor with parameters from classe Location
     * @param nameLocation 
     * @param latitude 
     * @param longitude
     * @param weather
     */
    public Location(String nameLocation, String latitude, String longitude, String weather) {
        this.nameLocation = nameLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
    }
    /**
     * Clone constructor of the class that has an object of the same class as a parameter
     * @param location
     */
    public Location(Location location) {
    	this(location.getNameLocation(), location.getLatitude(), location.getLongitude(), location.getWeather());
    }
	
    
    // 3 - gets e sets

    /**
     * This method will give the nameLocation
     * @return nameLocation
     */
    public String getNameLocation() {
        return nameLocation;
    }

    /**
     * This method will give the latitude
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method will give the longitude
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method will give the weather
     * @return weather
     */
    public String getWeather() {
        return weather;
    }


    // 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * Convert the class to a textual form
     */
    @Override
	public String toString() {
		return "Location [nameLocation=" + nameLocation + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", weather=" + weather + "]";
	}
}
