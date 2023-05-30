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

	// gets e sets

	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	// 5 - metódos complementares
	/**
	 * Metódo que tranforma a classe para um estilo textual
	 */
	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}

}
