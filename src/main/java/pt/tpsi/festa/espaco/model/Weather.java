package pt.tpsi.festa.espaco.model;

import lombok.Data;

/**
 * Representa informações sobre as condições climáticas.
 */
@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
