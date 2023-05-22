package pt.tpsi.festa.espaco.model;

public class Location {
   
	// 1 - atributos
	private String nameLocation;
    private String latitude;
    private String longitude;
    private String weather;
    private double temperature;
    private double temperatureMin;
    private double temperatureMax;
    
    // 2 - construtores 
	
    public Location() {
	}

    public Location(String nameLocation, String latitude, String longitude, String weather, double temperature, double temperatureMin, double temperatureMax) {
        this.nameLocation = nameLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
    }

    // 3 - gets e sets
    
	public String getNameLocation() {
        return nameLocation;
    }

    public String getWeather() {
        return weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    
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
