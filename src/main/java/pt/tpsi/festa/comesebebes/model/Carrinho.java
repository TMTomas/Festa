package pt.tpsi.festa.comesebebes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class Carrinho {
	// Atributos
	protected List<Product> carrinho = new ArrayList<Product>();

	// Acessores
	public List<Product> getCarrinho() {
		return carrinho;
	}

	// Construtor 1 - default
	public Carrinho() {

	}

	// Construtor 1 - com parametros
	public Carrinho(List<Product> carrinho) {
		super();
		this.carrinho = carrinho;
	}

	// Construtor 3 - cópia
	public Carrinho(Carrinho carrinho) {
		this(carrinho.getCarrinho());
	}

	// Comportamentos
	public String consultar() throws ProductFetchException, NoSuchStoreException {
		Map<String, Long> produtosAgrupados = carrinho.stream()
				.collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

		Map<String, Double> precosPorProduto = carrinho.stream()
				.collect(Collectors.groupingBy(Product::getName, Collectors.summingDouble(Product::getCurrentPrice)));

		String produtosOrdenados = produtosAgrupados.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(entry -> {
					String nomeProduto = entry.getKey();
					long quantidade = entry.getValue();
					double precoUnitario = precosPorProduto.get(nomeProduto) / quantidade;
					return "Item: " + nomeProduto + "\n Quantidade: " + quantidade + "\n Preço: "
							+ (Math.round(precoUnitario * 10000.0) / 10000.0) + "EUR\n--------------------------------";
				}).collect(Collectors.joining("\n"));

		return produtosOrdenados + "\nPreço Total: "
				+ (Math.round(carrinho.stream().mapToDouble(Product::getCurrentPrice).sum() * 10000.0) / 10000.0)
				+ "EUR";

	}

	public void adicionar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		ProductSearch productSearch = new ProductSearch();
		List<Product> produtos = productSearch.search(Store.PINGO_DOCE, nome);
		if (numeroProduto >= 1 && numeroProduto <= produtos.size()) {
			for (int i = 0; i < quantidade; i++) {
				carrinho.add(produtos.get(numeroProduto - 1));
			}
		}
	}

	public void alterar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		ProductSearch productSearch = new ProductSearch();
		List<Product> produto = productSearch.search(Store.PINGO_DOCE, nome);
		Map<String, Long> produtosAgrupados = carrinho.stream()
				.collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
		long quantidadeAtual = produtosAgrupados.getOrDefault(produto.get(numeroProduto - 1).getName(), 0l);

		if (quantidadeAtual < quantidade) {
			adicionar(nome, numeroProduto, (int) (quantidade - quantidadeAtual));
		} else {
			// COMPLETAR
		}
	}

	public void remover(int index) {
		carrinho.remove(index);
	}

	// Métodos Complementares
	@Override
	public String toString() {
		return "Carrinho [carrinho=" + carrinho + "]";
	}

}
