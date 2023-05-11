package pt.tpsi.festa.espaco;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MetereologiaRequest {

	public static void main(String[] args) {

		double lat = 39.201197300000004;
		double lon = -8.627226474862745;
		String token = "0bc9afaa68eeaa9997d66aa2404b4b5b";
		String Url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + token;

		try {
			URL url = new URL(Url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			MetereologiaResponse metereologiaResponse = new MetereologiaResponse(response.toString());
            double temperature = metereologiaResponse.getTemperature();
            System.out.println("Temperature: " + temperature);
            
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
				
	}
	
}
