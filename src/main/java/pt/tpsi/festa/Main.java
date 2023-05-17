package pt.tpsi.festa;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

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
		MetereologiaRequest request = new MetereologiaRequest();
		OpenStreetMap openStreetMap = new OpenStreetMap();

		List<OpenStreetMapLocation> locations =  openStreetMap.search("CNEMA, Santarem");

		MetereologiaModel model = request.createMetrologiaRequest(locations.get(0).getLatitute(), locations.get(0).getLongitude());

		System.out.println(model.getTemperatura().getTempC());

		/*
		locations.forEach(location -> {
			System.out.println("Latitude: " + location.getLatitute());
			System.out.println("Longitude: " + location.getLongitude());
			// Cria uma solicitação de metereologia
			MetereologiaModel model = request.createMetrologiaRequest( location.getLatitute(),location.getLongitude());

			System.out.println(model);
		});

		 */




	}

}
