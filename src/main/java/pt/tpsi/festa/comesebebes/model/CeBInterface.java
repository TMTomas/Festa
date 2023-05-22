package pt.tpsi.festa.comesebebes.model;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public interface CeBInterface {

	public String consultar(String produto) throws ProductFetchException, NoSuchStoreException;

	public void adicionar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException;

	public void alterar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException;

	public void remover(int index);
}