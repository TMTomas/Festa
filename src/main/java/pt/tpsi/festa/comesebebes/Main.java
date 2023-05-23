package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.Carrinho;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
		Carrinho carrinho = new Carrinho();
		carrinho.adicionar("morango", 0, 2);
		System.out.println(carrinho.consultar());
	}

}
