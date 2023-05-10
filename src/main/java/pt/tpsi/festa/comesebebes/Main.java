package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
		ComesEBebes teste = new ComesEBebes();
		teste.adicionarProduto("morango", 1);
		System.out.println(teste.getCarrinho());
		

	}

}
