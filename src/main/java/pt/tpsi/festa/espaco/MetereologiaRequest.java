package pt.tpsi.festa.espaco;

import org.json.JSONObject;
import pt.tpsi.festa.execeptions.RequestException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.*;

public class MetereologiaRequest {

	//Fazer um refactor tirando  a main da class
	double lat;
	double lon;
	String token = "0bc9afaa68eeaa9997d66aa2404b4b5b";
	String Url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + token;
	MetereologiaResponse metereologiaResponse;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public MetereologiaRequest(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public String createMetrologiaRequest() {
		try{
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(Url))
					.build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			this.metereologiaResponse  = new MetereologiaResponse(response.body());

			return response.body();
		}catch (IOException | InterruptedException e){
			throw new RequestException(e.getMessage());
		}
	}
}
