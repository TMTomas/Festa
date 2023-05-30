package pt.tpsi.festa;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;
import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationPlus;

import java.util.List;

/**
 * Classe principal que demonstra o uso da classe MetereologiaRequest e
 * MetereologiaModel.
 */

public class Main {

	/**
	 * Método principal que cria uma solicitação de metereologia e imprime a
	 * temperatura.
	 *
	 */

	public static void main(String[] args) throws LocationSearchException {
		 // Cria uma instância de MetereologiaRequest
		RequestMetreologiaAndLocation request = new RequestMetreologiaAndLocation();
		//Pesquisa com quase todos os Detalhes
		request.pesquisar("Santarem");
		/*
		OpenStreetMap requestLocation = new OpenStreetMap();
		List<OpenStreetMapLocation> locations = null;
		locations = requestLocation.search("Santarem");

		System.out.println(locations + "\n"+ locations.size());

		 */
	}

}
