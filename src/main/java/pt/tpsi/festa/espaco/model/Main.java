package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class Main {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;

    public int getTempC(){
        return (int) (temp - 273);
    }
    public int getMinTempC(){
        return (int) (temp_min - 273);
    }
    public int getMaxTempC(){
        return (int) (temp_max - 273);
    }
}
