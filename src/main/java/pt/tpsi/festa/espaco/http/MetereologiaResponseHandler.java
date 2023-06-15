package pt.tpsi.festa.espaco.http;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
/**
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
public class MetereologiaResponseHandler implements HttpClientResponseHandler<MetereologiaModel> {
	
	// 1 - atributos
	private final ObjectMapper objectMapper;
	
	// 2 - construtores
	/**
	 * Constructor for the Meteorology ResponseHandler class
	 */
	public MetereologiaResponseHandler() {
		this.objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	// 3 - gets e sets
	
	// 4 - comportamentos
	/**
	 * Method that will check the response code,
	 * if successful and will read the content for class MetereologiaModel
	 * If it fails, it will return null
	 *
	 * @param response The response is the request response
	 * @return the read Mapper object and to the MeteorologyModel class
	 */
	@Override
	public MetereologiaModel handleResponse(ClassicHttpResponse response) throws IOException {
		if(response.getCode() < 200 || response.getCode() > 299){
			return null;
		}
		try (InputStream body = response.getEntity().getContent()) {
			return this.objectMapper.readValue(body, new TypeReference<MetereologiaModel>() {
			});
		}
	}

	
	
	// 5 - metodos complementares
	/**
	 * Convert the class to a textual form
	 */
	@Override
	public String toString() {
		return "MetereologiaResponseHandler [objectMapper=" + objectMapper + "]";
	}
}
