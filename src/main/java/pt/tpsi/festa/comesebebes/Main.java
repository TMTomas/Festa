package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.Carrinho;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
		Carrinho carrinho = new Carrinho();
		carrinho.alterar("morango", 2, 4);
		carrinho.alterar("morango", 2, 0);
		System.out.println(carrinho.consultar());
	}

}
