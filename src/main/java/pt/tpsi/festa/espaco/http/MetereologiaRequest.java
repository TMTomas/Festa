package pt.tpsi.festa.espaco.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
import pt.tpsi.festa.execeptions.RequestException;

import java.io.IOException;

public class MetereologiaRequest {
	
	// 1 - atributos
	/**
	 * Atributo do tipo string, que guarda o token que da a acesso a api utilizada na classe
	 */
	private final String token = "0bc9afaa68eeaa9997d66aa2404b4b5b";
	/**
	 * Atributo do tipo MetereologiaResponseHandler, que instancia a classe
	 */
	private final MetereologiaResponseHandler metereologiaResponseHandler;

	// 2 - construtores
	/**
	 * Construtores do objeto que faz o request a metereologia
	 */
	public MetereologiaRequest() {
		metereologiaResponseHandler = new MetereologiaResponseHandler();
	}
	// 3 - gets e set
	
	public MetereologiaResponseHandler getMetereologiaResponseHandler() {
		return metereologiaResponseHandler;
	}
	// 4 - comportamentos
	/**
	 * Este metodo serve para fazer um request, atraves de uma API de metereologia, da cidade escolhida
	 * o nome da cidade é traduzido em Latitude e Longitude
	 * @param latitude da cidade
	 * @param longitude da cidade 
	 * @return retorno o resultado do pedido, com varios atributos 
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
	 * metódo que faz uma apresentação de maneira textual
	 */
	@Override
	public String toString() {
		return "MetereologiaRequest [token=" + token + ", metereologiaResponseHandler=" + metereologiaResponseHandler
				+ "]";
	}
	
}
