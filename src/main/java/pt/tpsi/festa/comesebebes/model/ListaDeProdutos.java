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
	protected ArrayList<Product> baseDeDados;
	protected int atual;

	// ACESSORES
	public ArrayList<Product> getBaseDeDados() {
		return baseDeDados;
	}

	public int getAtual() {
		return atual;
	}

	// CONSTRUTOR 1 - default
	public ListaDeProdutos() {
		baseDeDados = new ArrayList<>();
	}

	// CONSTRUTOR 2 - com parâmetros
	public ListaDeProdutos(ArrayList<Product> baseDeDados, int atual) {
		super();
		this.baseDeDados = baseDeDados;
		this.atual = atual;
	}

	// COMPORTAMENTOS
	public String consultar(String nome) throws ProductFetchException, NoSuchStoreException {
		ProductSearch productSearch = new ProductSearch();
		List<Product> produtos = productSearch.search(Store.PINGO_DOCE, nome);

		baseDeDados.addAll(produtos);

		String resultado = "";
		for (int i = 0; i < 50 && i < produtos.size(); i++) {
			Product produto = produtos.get(i);
			resultado += "Produto " + (i + 1) + ":\n";
			resultado += "Nome: " + produto.getName() + "\n";
			resultado += "Preço: " + produto.getCurrentPrice() + produto.getCurrency() + "\n";
			resultado += "--------------------------------\n";
		}

		return resultado;
	}

	public void recuar() {
		if (atual > 0) {
			atual--;
		}
	}

	public void avancar() {
		if (atual < baseDeDados.size() - 1) {
			atual++;
		}
	}

	public void fim() {
		atual = baseDeDados.size() - 1;
	}

	public void inicio() {
		atual = 0;
	}

	public Product pesquisarChave(String nome, int numero) {
		this.atual = numero;
		return baseDeDados.get(numero);

	}

	public int pesquisarChave(Product produto) {
		this.atual = baseDeDados.indexOf(produto);
		return baseDeDados.indexOf(produto);

	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ListaDeProdutos [baseDeDados=" + baseDeDados + "]";
	}
}
