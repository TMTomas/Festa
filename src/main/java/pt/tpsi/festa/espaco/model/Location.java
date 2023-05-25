package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class Location {
	
	// 1 - atributos 
	/**
	 * Atributos necessarios para esta classe
	 * nameLocatios que vai guardar o nome do local 
	 * latitude para guardar a latitude do local localizado no nameLocation
	 * logitude para guardar a longitude do local localizado no nameLocation
	 * weather guarda como está o clima no local guardado no nameLocation
	 */
    private String nameLocation;
    private String latitude;
    private String longitude;
    private String weather;

    // 2 - construtores
    /**
     * construtor default da classe Location
     */
    public Location() {
    }
    /**
     * construtor com paramentros da classe Location
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

	
    
    // 3 - gets e sets
    // a anotação Data ja serve para ter os gets e sets da classe
    
    // 4 - comportamentos
    
    // 5 - metodos complementares
    /**
     * metódo toString para representar de forma escrita a classe
     */
    @Override
	public String toString() {
		return "Location [nameLocation=" + nameLocation + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", weather=" + weather + "]";
	}
}
