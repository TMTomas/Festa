package pt.tpsi.festa.espaco.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

public class MetereologiaResponseHandler implements HttpClientResponseHandler<MetereologiaModel> {
	private final ObjectMapper objectMapper;

	public MetereologiaResponseHandler() {
		this.objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

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
}
