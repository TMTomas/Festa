package pt.tpsi.festa;

import pt.tpsi.festa.espaco.MetereologiaRequest;

public class Main {

	public static void main(String[] args) {
		MetereologiaRequest request = new MetereologiaRequest(39.201197300000004,-8.627226474862745);

		System.out.println(request.createMetrologiaRequest());

	}

}
