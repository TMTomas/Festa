package pt.tpsi.festa.comesebebes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class ComesEBebes {
	// ATRIBUTOS
	protected List<Product> carrinho = new ArrayList<Product>();

	// ACESSORES
	public String getCarrinho() {
		return carrinho.stream().sorted(Comparator.comparingDouble(Product::getCurrentPrice).reversed())
				.map(product -> "Item: " + product.getName() + "\n Preço: " + product.getCurrentPrice()
						+ product.getCurrency() + "\n--------------------------------")
				.collect(Collectors.joining("\n"));
	}

	public void setCarrinho(List<Product> carrinho) {
		this.carrinho = carrinho;
	}

	// CONSTRUTOR 1 - default
	public ComesEBebes() {
	}

	// CONSTRUTOR 2 - com parâmetros
	public ComesEBebes(ArrayList<Product> carrinho) {
		super();
		this.carrinho = carrinho;
	}

	// CONSTRUTOR 3 - copia
//	public ComesEBebes(ComesEBebes comesEBebes) {
//		this(comesEBebes.getCarrinho());
//	}

	// COMPORTAMENTOS
	public void buscarProduto(String nome) throws ProductFetchException, NoSuchStoreException {
		ProductSearch productSearch = new ProductSearch();
		productSearch.search(Store.PINGO_DOCE, nome).forEach(product -> {
			System.out.println(product.getName());
			System.out.println(product.getCurrentPrice());
		});
	}

	public void adicionarProduto(String nome, int id) throws ProductFetchException, NoSuchStoreException {
		ProductSearch productSearch = new ProductSearch();
		carrinho.add(productSearch.search(Store.PINGO_DOCE, nome).get(id));
	}

//	public void adicionarProduto(String nome, int id, int quantidade)
//			throws ProductFetchException, NoSuchStoreException {
//		ProductSearch productSearch = new ProductSearch();
//		carrinho.add(productSearch.search(Store.PINGO_DOCE, nome).get(id));
//	}

	public void removerProduto(int id) {
		carrinho.remove(id);
	}

	// METODOS COMPLEMENTARES

}