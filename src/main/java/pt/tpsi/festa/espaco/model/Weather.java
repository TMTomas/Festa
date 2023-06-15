package pt.tpsi.festa.espaco.model;

import lombok.Data;
/**
 * This class Just save the data from the json that are given from the {@link pt.tpsi.festa.espaco.http.MetereologiaRequest}
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
@Data
public class Weather {

	// 1 - atributos
	private int id;
	private String main;
	private String description;
	private String icon;

	// gets e sets

	/**
	 * This method will give the id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method will give the main
	 * @return main
	 */
	public String getMain() {
		return main;
	}

	/**
	 * This method will give the description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method will give the Icon
	 * @return Icon
	 */
	public String getIcon() {
		return icon;
	}

	// 5 - metódos complementares
	/**
	 * Convert the class to a textual form
	 */
	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}

}
