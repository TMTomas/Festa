package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;
import pt.tpsi.festa.comesebebes.model.ListaDeProdutos;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
//		ComesEBebes teste = new ComesEBebes();
//		teste.adicionar("LARANJA", 1, 2);
//		teste.remover(1);
//		System.out.println(teste.getCarrinho());
//		System.out.println(teste.consultar("Morango"));
		ListaDeProdutos produtos = new ListaDeProdutos();
//		System.out.println(produtos.consultar("morango"));
		System.out.println(produtos);
	}

}
