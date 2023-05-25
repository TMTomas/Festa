package pt.tpsi.festa.comesebebes.api;

import java.util.ArrayList;
import java.util.List;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.Carrinho;
import pt.tpsi.festa.comesebebes.model.ListaDeProdutos;
import pt.tpsi.festa.comesebebes.model.Produto;
import pt.tpsi.festa.comesebebes.model.Produto2;

/**
 * API utilizada no projeto que busca produtos.
 * 
 * @see <a href="https://mercadao.pt/store/pingo-doce">Loja</a>
 * @see ListaDeProdutos
 * @see Carrinho
 */
public class ApiProdutos {
	// ATRIBUTOS
	protected ProductSearch productSearch;

	// ACESSORES
	public ProductSearch getProductSearch() {
		return productSearch;
	}

	// CONSTRUTOR
	public ApiProdutos() {
		productSearch = new ProductSearch();
	}

	// COMPORTAMENTOS

	/**
	 * Busca produtos utilizando a API e os converte para a classe {@link Produto}.
	 * 
	 * @param nome o nome do produto a ser buscado.
	 * @return a lista de produtos convertidos para a classe Produto.
	 * @throws NoSuchStoreException  caso a loja especificada não exista.
	 * @throws ProductFetchException caso ocorra um erro ao buscar os produtos.
	 */
	public List<Produto> buscarProdutos(String nome) {
		List<Produto> produtos = new ArrayList<>();
		try {
			List<Product> apiProdutos = productSearch.search(Store.PINGO_DOCE, nome);
			for (Product apiProduto : apiProdutos) {
				Produto produto = new Produto2(apiProduto.getName(), apiProduto.getCurrentPrice(),
						apiProduto.getBrand(), 0, apiProduto.getUrl(), apiProduto.getImage(), apiProduto.isAvailable());
				produtos.add((Produto2) produto);
			}
		} catch (NoSuchStoreException | ProductFetchException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ApiProdutos [productSearch=" + productSearch + "]";
	}
}
