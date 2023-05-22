package pt.tpsi.festa.comesebebes.model;

import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class ComesEBebes implements CeBInterface {
	// ATRIBUTOS
	private Carrinho carrinho;
	private ListaDeProdutos listaDeProdutos;

	// ACESSORES
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public ListaDeProdutos getListaDeProdutos() {
		return listaDeProdutos;
	}

	// CONSTRUTOR 1 - default
	public ComesEBebes() throws NoSuchStoreException, ProductFetchException {
		this.carrinho = new Carrinho();
		this.listaDeProdutos = new ListaDeProdutos();
	}

	public ComesEBebes(Carrinho carrinho, ListaDeProdutos listaDeProdutos) {
		super();
		this.carrinho = carrinho;
		this.listaDeProdutos = listaDeProdutos;
	}

	// COMPORTAMENTOS
	@Override
	public String consultar(String produto) throws ProductFetchException, NoSuchStoreException {
		return listaDeProdutos.consultar(produto);

	}

	@Override
	public void adicionar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		carrinho.adicionar(nome, numeroProduto, quantidade);

	}

	@Override
	public void alterar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		carrinho.alterar(nome, numeroProduto, quantidade);
	}

	@Override
	public void remover(int index) {
		carrinho.remover(index);

	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ComesEBebes [carrinho=" + carrinho + ", listaDeProdutos=" + listaDeProdutos + "]";
	}

}
