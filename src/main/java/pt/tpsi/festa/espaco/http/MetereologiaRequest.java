package pt.tpsi.festa.espaco.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
import pt.tpsi.festa.espaco.execeptions.RequestException;

import java.io.IOException;
/**
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
public class MetereologiaRequest {
	
	// 1 - atributos
	/**
	 * Atributo do tipo string, que guarda o token que da a acesso a api utilizada na classe
	 */
	private final String token = "0bc9afaa68eeaa9997d66aa2404b4b5b";

	private final MetereologiaResponseHandler metereologiaResponseHandler;

	// 2 - construtores
	/**
	 * Construtores do objeto que faz o request a metereologia
	 */
	public MetereologiaRequest() {
		metereologiaResponseHandler = new MetereologiaResponseHandler();
	}
	// 3 - gets e set

	// 4 - comportamentos
	/**
	 * This method is used to make a request, and through an API metrology, from the city
	 * is used the Latitude and Longitude
	 *
	 * @param latitude from the city
	 * @param longitude from the city
	 * @return result of the request, with several attributes
	 */
	public MetereologiaModel createMetrologiaRequest(String latitude, String longitude) {
		MetereologiaModel result = null;
		try{

			String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + token;
			final HttpGet request = new HttpGet(url);
			request.setHeader("Accept", "application/json");
			request.setHeader("Content-Type", "application/json");

			try (CloseableHttpClient client = HttpClients.createDefault()) {
				result = client.execute(request, metereologiaResponseHandler);
			}
		}catch (IOException e){
			throw new RequestException(e.getMessage());
		}
		return result;
	}
	
	// 5 - metodos complementares
	/**
	 * Convert the class to a textual form
	 */
	@Override
	public String toString() {
		return "MetereologiaRequest [token=" + token + ", metereologiaResponseHandler=" + metereologiaResponseHandler
				+ "]";
	}
	
}
