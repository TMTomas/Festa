package pt.tpsi.festa;

import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

/**
 * Classe principal que demonstra o uso da classe MetereologiaRequest e
 * MetereologiaModel.
 */

public class Main {

	/**
	 * Método principal que cria uma solicitação de metereologia e imprime a
	 * temperatura.
	 *
	 * @args Os argumentos de linha de comando. Eles são ignorados neste
	 *             exemplo.
	 */

	public static void main(String[] args) {
		 // Cria uma instância de MetereologiaRequest
		MetereologiaRequest request = new MetereologiaRequest();
		// Cria uma solicitação de metereologia
		request.createMetrologiaRequest();
		 // Cria uma instância de MetereologiaModel
		MetereologiaModel metereologiaModel = new MetereologiaModel();
		// Imprime a temperatura
		System.out.println(metereologiaModel.getTemperatura());

	}

}
