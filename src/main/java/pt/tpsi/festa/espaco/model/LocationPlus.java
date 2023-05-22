package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class LocationPlus extends Location{
   
	// 1 - atributos
    private double temperature;
    private double temperatureMin;
    private double temperatureMax;
    private String type;
    private String icon;
    
    // 2 - construtores 
	
    public LocationPlus() {
	}

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

    // 4 - comportamentos
    
    // 5 - metodos complementares
    @Override
    public String toString() {
        return "LocationPlus{" +
                ", temperature=" + temperature +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                '}';
   }



	
}
