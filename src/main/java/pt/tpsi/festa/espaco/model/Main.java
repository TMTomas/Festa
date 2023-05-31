package pt.tpsi.festa.espaco.model;

import lombok.Data;
/**
 * This class Just save the data from the json that are given from the {@link pt.tpsi.festa.espaco.http.MetereologiaRequest}
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
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

    /**
     * A getter that will convert the temperature kelvins to degrees
     * @return temp the temperature converted
     */
    public int getTempC(){
        return (int) (temp - 273);
    }

    /**
     * A getter that will convert the Minimum temperature kelvins to degrees
     * @return temp_min the minimum temperature converted
     */
    public int getMinTempC(){
        return (int) (temp_min - 273);
    }

    /**
     * A getter that will convert the Max temperature kelvins to degrees
     * @return temp_max the max temperature converted
     */
    public int getMaxTempC(){
        return (int) (temp_max - 273);
    }
}
