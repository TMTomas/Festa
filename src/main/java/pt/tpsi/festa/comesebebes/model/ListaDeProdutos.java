package pt.tpsi.festa.comesebebes.model;

import java.util.ArrayList;
import java.util.List;
import pt.tpsi.festa.comesebebes.api.ApiProdutos;

/**
 * Representa uma lista de produtos. Essa classe possui uma lista de produtos e
 * uma API para buscar produtos
 * 
 * @author André, Danilo, Duarte e Rodrigo
 * @version 1.0.0
 * @see ApiProdutos
 * @see Carrinho
 * 
 */
public class ListaDeProdutos {
	// ATRIBUTOS
	protected List<Produto> lista = new ArrayList<>();
	protected ApiProdutos apiProdutos = new ApiProdutos();

	// ACESSORES

	/**
	 * Obtém a lista de produtos disponiveis através da API.
	 *
	 * @return a lista de produtos.
	 */
	public List<Produto> getLista() {
		return lista;
	}

	/**
	 * Getter para a API de produtos.
	 *
	 * @return A API de produtos.
	 */
	public ApiProdutos getApiProdutos() {
		return apiProdutos;
	}

	/**
	 * Construtor padrão da ListaDeProdutos
	 */
	public ListaDeProdutos() {

	}

	/**
	 * Construtor da ListaDeProdutos com uma lista pré-existente.
	 * 
	 * @param lista a lista de produtos pré-existente
	 */
	public ListaDeProdutos(List<Produto> lista) {
		this.lista = lista;
	}

	/**
	 * Construtor de cópia da ListaDeProdutos.
	 *
	 * @param lista a lista de produtos a ser copiada.
	 */
	public ListaDeProdutos(ListaDeProdutos lista) {
		this(lista.getLista());
	}

	// COMPORTAMENTOS

	/**
	 * Consulta a lista de produtos com base em um nome.
	 *
	 * @param nome o nome dos produtos a serem consultados.
	 * @return uma string que contém informações dos produtos consultados.
	 */
	public String consultar(String nome, boolean isProduto2) {
		List<Produto> produtos = apiProdutos.buscarProdutos(nome);
		String atributosExtras = "";
		String resultado = "";
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);

			if (produto instanceof Produto2 && isProduto2) {
				Produto2 produto2 = (Produto2) produto;
				String url = produto2.getUrl();
				String imagem = produto2.getImagem();
				atributosExtras = " Url: " + url + "\n Imagem: " + imagem + "\n";
			}

			resultado += "Índice " + (i) + ":\n";
			resultado += " Nome: " + produto.getNome() + "\n";
			resultado += " Preço: " + produto.getPreco() + "EUR" + "\n";
			resultado += " Marca: " + produto.getMarca() + "\n";
			resultado += atributosExtras;
			resultado += "--------------------------------\n";
		}

		return resultado;
	}

	// MÉTODOS COMPLEMENTARES

	/**
	 * Retorna uma representação em String da ListaDeProdutos.
	 *
	 * @return uma string representando a ListaDeProdutos.
	 */
	@Override
	public String toString() {
		return "ListaDeProdutos [lista=" + lista + "]";
	}
}
