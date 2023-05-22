package pt.tpsi.festa;

import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;

/**
 * Classe principal que demonstra o uso da classe MetereologiaRequest e
 * MetereologiaModel.
 */

public class Main {

	/**
	 * Método principal que cria uma solicitação de metereologia e imprime a
	 * temperatura.
	 *
	 */

	public static void main(String[] args) throws LocationSearchException {
		 // Cria uma instância de MetereologiaRequest
		RequestMetreologiaAndLocation request = new RequestMetreologiaAndLocation();
		//Pesquisa com quase todos os Detalhes
		System.out.println(request.pesquisar("CNEMA, Santarem").get(0).getNameLocation());
		System.out.println(request.selecionar(0));
	}

}
