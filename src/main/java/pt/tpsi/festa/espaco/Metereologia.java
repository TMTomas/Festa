package pt.tpsi.festa.espaco;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.List;

public class Metereologia {
	
	// 1 - ATRIBUTOS
    private List<JSONObject> weather;
    @JsonProperty("main")
    private List<JSONObject> temperature;
    private List<JSONObject> wind;

	// 2 - CONSTRUTORES
	
	// 3 - GETS E SETS

	// 4 - COMPORTAMENTOS
	
	// 5 - METODOS COMPLEMENTARES
	
}
