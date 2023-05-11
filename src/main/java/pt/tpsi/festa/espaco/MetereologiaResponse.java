package pt.tpsi.festa.espaco;

import java.io.IOException;
import org.json.JSONObject;

public class MetereologiaResponse {
	
	// 1 - atributos
	
	private JSONObject data;
	
	// 2 - construtor
	
	public MetereologiaResponse() {
		
	}
	public MetereologiaResponse(String response) throws IOException {
        this.data = new JSONObject(response);
    }
	public MetereologiaResponse(MetereologiaResponse metereologiaResponse) {
		
	}
	
	// 3 - get e set
	
	// 4 - comportamentos
	
	public double getTemperature() throws IOException {
        return this.data.getJSONObject("main").getDouble("temp");
    }
	
	
	// 5 - metodos complementares
	
	@Override
	public String toString() {
		return "MetereologiaResponse [data=" + data + "]";
	}
}
