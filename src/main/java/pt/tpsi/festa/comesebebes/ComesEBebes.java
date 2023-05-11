package pt.tpsi.festa.comesebebes;

import java.util.ArrayList;
import java.util.List;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class ComesEBebes {
	// ATRIBUTOS
	protected List<Product> carrinho = new ArrayList<Product>();

	// ACESSORES
	public List<Product> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Product> carrinho) {
		this.carrinho = carrinho;
	}

	// CONSTRUTOR 1 - default
	public ComesEBebes() {
	}

	// CONSTRUTOR 2 - com parâmetros
	public ComesEBebes(ArrayList<Product> carrinho, ProductSearch productSearch) {
		super();
		this.carrinho = carrinho;
		Comparator<Product> priceComparator = (p1, p2) -> Double.compare(p1.getCurrentPrice(), p2.getCurrentPrice());	 
	    	List productList = null;
		Collections.sort(productList, priceComparator);
	}

	// 4 - COMPORTAMENTOS
	public void buscarProduto(String nome) throws ProductFetchException, NoSuchStoreException {
		ProductSearch productSearch = new ProductSearch();
		productSearch.search(Store.PINGO_DOCE, nome).forEach(pro -> {
		System.out.println(pro.getName());
		System.out.println(pro.getCurrentPrice());
		}
		);
	}

	public void adicionarProduto(String nome, int id) throws ProductFetchException, NoSuchStoreException {
		ProductSearch productSearch = new ProductSearch();
			carrinho.add(productSearch.search(Store.PINGO_DOCE, nome).get(id));
	}

	// 5 - METODOS COMPLEMENTARES

}
