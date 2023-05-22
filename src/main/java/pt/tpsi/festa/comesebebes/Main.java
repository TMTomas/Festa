package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
		ComesEBebes comesEBebes = new ComesEBebes();
		comesEBebes.consultar("favaios");
		System.out.println(comesEBebes.getCarrinho().consultar());
	}

}
