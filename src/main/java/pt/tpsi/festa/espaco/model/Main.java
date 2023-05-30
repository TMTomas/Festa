package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class Main {
	/**
	 * atributos declarados que recebem os seus respectivos valores
	 */
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;
    /**
     * um get para a temperatura convertida de kelvins para graus
     * @return a temperatura convertida
     */
    public int getTempC(){
        return (int) (temp - 273);
    }
    /**
     * um get para a temperatura minima convertida de kelvins para graus
     * @return a temperatura convertida
     */
    public int getMinTempC(){
        return (int) (temp_min - 273);
    }
    /**
     * um get para a temperatura maxima convertida de kelvins para graus
     * @return a temperatura convertida
     */
    public int getMaxTempC(){
        return (int) (temp_max - 273);
    }
}
