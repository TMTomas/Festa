package pt.tpsi.festa.comesebebes.model;

import java.util.ArrayList;
import java.util.List;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class ListaDeProdutos {
	// ATRIBUTOS
	protected List<Produto> lista;

	// ACESSORES
	public List<Produto> getLista() {
		return lista;
	}

	public List<Produto> getLista(String nomeProduto) throws NoSuchStoreException, ProductFetchException {
		lista.addAll(getProdutos(nomeProduto));
		return lista;
	}

	// CONSTRUTOR 1 - default
	public ListaDeProdutos() {
		lista = new ArrayList<>();
	}

	// CONSTRUTOR 2 - com parâmetros
	public ListaDeProdutos(List<Produto> lista) {
		super();
		this.lista = lista;
	}

	// CONSTRUTOR 3 - cópia
	public ListaDeProdutos(ListaDeProdutos lista) {
		this(lista.getLista());
	}

	// COMPORTAMENTOS
	public String consultar(String nome) throws ProductFetchException, NoSuchStoreException {
		lista.addAll(getProdutos(nome));

		String resultado = "";
		for (int i = 0; i < getProdutos(nome).size(); i++) {
			Produto produto = getProdutos(nome).get(i);
			resultado += "Índice " + (i) + ":\n";
			resultado += "Nome: " + produto.getNome() + "\n";
			resultado += "Preço: " + produto.getPreco() + "EUR" + "\n";
			resultado += "Preço: " + produto.getMarca() + "\n";
			resultado += "--------------------------------\n";
		}

		return resultado;
	}

	public Produto pesquisarProduto(int index) {
		return lista.get(index);
	}

	protected List<Produto> getProdutos(String nome) throws NoSuchStoreException, ProductFetchException {
		// Converter objetos da classe Product da API para objetos da classe Produto
		ProductSearch productSearch = new ProductSearch();
		List<Product> apiProdutos = productSearch.search(Store.PINGO_DOCE, nome);
		List<Produto> produtos = new ArrayList<>();
		for (Product apiProduto : apiProdutos) {
			Produto produto = new Produto(apiProduto.getName(), apiProduto.getCurrentPrice(), apiProduto.getBrand());
			produtos.add(produto);
		}
		return produtos;
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ListaDeProdutos [lista=" + lista + "]";
	}
}
