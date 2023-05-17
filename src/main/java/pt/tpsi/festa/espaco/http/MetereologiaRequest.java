package pt.tpsi.festa.espaco.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
import pt.tpsi.festa.execeptions.RequestException;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class MetereologiaRequest {
	private final String token = "0bc9afaa68eeaa9997d66aa2404b4b5b";
	private final MetereologiaResponseHandler metereologiaResponseHandler;

	public MetereologiaRequest() {
		metereologiaResponseHandler = new MetereologiaResponseHandler();
	}

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
}
