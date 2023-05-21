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

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
