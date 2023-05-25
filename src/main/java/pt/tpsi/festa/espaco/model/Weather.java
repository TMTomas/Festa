package pt.tpsi.festa.espaco.model;

import lombok.Data;

/**
 * Representa informações sobre as condições climáticas.
 */
@Data
public class Weather {
    
	// 1 - atributos
	private int id;
    private String main;
    private String description;
    private String icon;
    
    // gets e sets são tratados pela anotação Data 
}
