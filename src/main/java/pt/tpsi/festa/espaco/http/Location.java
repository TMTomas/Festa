package pt.tpsi.festa.espaco.http;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String nameLocation;
    private String weather;
    private double temperature;
    private double temperatureMin;
    private double temperatureMax;

    public Location(String nameLocation, String weather, double temperature, double temperatureMin, double temperatureMax) {
        this.nameLocation = nameLocation;
        this.weather = weather;
        this.temperature = temperature;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
    }

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

    public List<Location> locations(int size){
        List<Location> list = new ArrayList<>();
        for(int i = 0 ; i < size; i++ ){
            list.add(new Location(getNameLocation(),getWeather(),getTemperature(),getTemperatureMin(),getTemperatureMax()));
        }
        return list;
    }
}
