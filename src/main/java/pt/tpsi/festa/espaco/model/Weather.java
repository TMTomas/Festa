package pt.tpsi.festa.espaco.model;

import lombok.Data;

/**
 * Representa informações sobre as condições climáticas.
 */
@Data
public class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}
