package pt.tpsi.festa;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

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
		MetereologiaRequest request = new MetereologiaRequest();
		OpenStreetMap openStreetMap = new OpenStreetMap();
		OpenStreetMapLocation openStreetMapLocation = new OpenStreetMapLocation();
		openStreetMap.search("CNEMA, Santarém");
		// Cria uma solicitação de metereologia
		MetereologiaModel model = request.createMetrologiaRequest( openStreetMapLocation.getLatitute(),openStreetMapLocation.getLongitude());

		System.out.println(model.getTemperatura().temp);


	}

}
