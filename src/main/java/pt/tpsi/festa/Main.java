package pt.tpsi.festa;

import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

public class Main {

	public static void main(String[] args) {
		MetereologiaRequest request = new MetereologiaRequest();
		request.createMetrologiaRequest();
		MetereologiaModel metereologiaModel = new MetereologiaModel();
		System.out.println(metereologiaModel.getTemperatura());

	}

}
