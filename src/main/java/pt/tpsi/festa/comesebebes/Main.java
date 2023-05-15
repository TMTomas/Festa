package pt.tpsi.festa.comesebebes;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class Main {

	public static void main(String[] args) throws ProductFetchException, NoSuchStoreException {
		ComesEBebes teste = new ComesEBebes();
		teste.buscarProduto("morango");
		teste.adicionarProduto("morango", 1);
		teste.adicionarProduto("morango", 1);
		teste.adicionarProduto("morango", 1); //id = numero do produto da lista 
		teste.adicionarProduto("morango", 2);
		teste.adicionarProduto("morango", 5);
		System.out.println(teste.getCarrinho());
		System.out.println(teste.getCarrinho());

	}

}
