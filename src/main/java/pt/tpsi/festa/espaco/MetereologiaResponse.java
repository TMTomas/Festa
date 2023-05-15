package pt.tpsi.festa.espaco;

import java.io.IOException;
import org.json.JSONObject;

public class MetereologiaResponse {
	
	// 1 - atributos
	
	private final JSONObject responseData;
	
	// 2 - construtor

	public MetereologiaResponse(String responseData) {
		this.responseData = new JSONObject(responseData);
	}

	// 3 - get e set

	// 4 - comportamentos
	
	public double getTemperature() throws IOException {
        return this.responseData.getJSONObject("main").getDouble("temp");
    }

	public String getWeather(){
		return responseData.getJSONObject("weather").getString("description");
	}
	
	
	// 5 - metodos complementares
	
	@Override
	public String toString() {
		return "MetereologiaResponse [data=" + responseData + "]";
	}
}
