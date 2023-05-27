package pt.tpsi.festa.comesebebes.model;

import pt.tpsi.festa.comesebebes.api.ApiProdutos;

/**
 * Classe que representa o produto de uma loja.
 * 
 * @author André, Danilo, Duarte e Rodrigo
 * @version 1.0.0
 * @see ApiProdutos
 * @see Produto
 */
public class Produto2 extends Produto {
	// ATRIBUTOS
	protected String url;
	protected String imagem;
	protected boolean disponivel;

	// ACESSORES

	/**
	 * Retorna a url do produto
	 * 
	 * @return a url do produto
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Retorna a imagem do produto
	 * 
	 * @return o link para a imagem do produto
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * Diz se o produto está ou nao disponivel
	 * 
	 * @return estado da disponibilidade do produto
	 */
	public boolean isDisponivel() {
		return disponivel;
	}

	/**
	 * Cria um construtor vazio da classe Produto2.
	 */
	public Produto2() {

	}

	/**
	 * Cria uma instância da classe Produto2 com os parâmetros especificados.
	 *
	 * @param nome       o nome do produto.
	 * @param preco      o preço do produto.
	 * @param marca      a marca do produto.
	 * @param quantidade a quantidade do produto.
	 * @param url        a url do produto.
	 * @param imagem     a imagem do produto.
	 * @param disponivel a disponibilidade do produto.
	 */
	public Produto2(String nome, Double preco, String marca, int quantidade, String url, String imagem,
			boolean disponivel) {
		super(nome, preco, marca, quantidade);
		this.url = url;
		this.imagem = imagem;
		this.disponivel = disponivel;
	}

	/**
	 * Cria uma cópia do produto especificado.
	 *
	 * @param produto o produto a ser copiado.
	 */
	public Produto2(Produto2 produto) {
		this(produto.getNome(), produto.getPreco(), produto.getMarca(), produto.getQuantidade(), produto.getUrl(),
				produto.getImagem(), produto.isDisponivel());
	}

	// MÉTODOS COMPLEMENTARES
	
	/**
	 * Retorna uma representação em formato String do produto.
	 *
	 * @return uma string que representa o produto
	 */
	@Override
	public String toString() {
		return "Produto2 [nome=" + nome + ", preco=" + preco + "EUR, marca=" + marca + ", quantidade=" + quantidade
				+ ", url=" + url + ", imagem=" + imagem + ", disponivel=" + disponivel + "]";
	}
}
