package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class Location {
   
	// 1 - atributos
	private String nameLocation;
    private String latitude;
    private String longitude;
    private String weather;
    private double temperature;
    private double temperatureMin;
    private double temperatureMax;
    private String type;
    private String icon;
    
    // 2 - construtores 
	
    public Location() {
	}

    public Location(String nameLocation, String latitude, String longitude, String weather, double temperature, double temperatureMin, double temperatureMax, String type, String icon) {
        this.nameLocation = nameLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.type = type;
        this.icon = icon;
    }

    // 3 - gets e sets

    // 4 - comportamentos
    
    // 5 - metodos complementares
    @Override
    public String toString() {
        return "Location{" +
                "nameLocation='" + nameLocation + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", weather='" + weather + '\'' +
                ", temperature=" + temperature +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                '}';
   }
}
