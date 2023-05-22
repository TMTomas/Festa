package pt.tpsi.festa;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.http.MetereologiaRequest;
import pt.tpsi.festa.espaco.http.RequestMetreologiaAndLocation;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

import java.util.List;

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

		//Pesquisa so com os detalhes basicos
		System.out.println(request.pesquisarLessDetails("CNEMA, Santarem").get(0).getNameLocation());
		System.out.println(request.selecionarLess(0));
	}

}
