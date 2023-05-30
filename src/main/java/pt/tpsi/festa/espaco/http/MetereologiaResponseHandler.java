package pt.tpsi.festa.espaco.http;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

public class MetereologiaResponseHandler implements HttpClientResponseHandler<MetereologiaModel> {
	
	// 1 - atributos
	private final ObjectMapper objectMapper;
	
	// 2 - construtores
	/**
	 * Construtor para a classe MeterologiaResponseHandler
	 */
	public MetereologiaResponseHandler() {
		this.objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	// 3 - gets e sets
	
	// 4 - comportamentos
	/**
	 * Metódo que vai verificar o codigo de resposta,
	 * se for bem sucedido e irá ler o conteudo para classe MetereologiaModel
	 * Caso falhe irá retornar null
	 * @param response O response é a resposta do request
	 * @return o objetoMapper lido e para a classe MetereoogiaModel
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
	 * Transforma a classe para uma forma textual
	 */
	@Override
	public String toString() {
		return "MetereologiaResponseHandler [objectMapper=" + objectMapper + "]";
	}
}
