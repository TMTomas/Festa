package pt.tpsi.festa.comesebebes.model;

import pt.tpsi.festa.comesebebes.api.ApiProdutos;

/**
 * Classe que representa o produto de uma loja.
 * 
 * @author André, Danilo, Duarte e Rodrigo
 * @version 1.0.0
 * @see ApiProdutos
 */
public class Produto {
	// ATRIBUTOS
	protected String nome;
	protected Double preco;
	protected String marca;
	protected int quantidade;

	// ACESSORES

	/**
	 * Retorna o nome do produto
	 * 
	 * @return o nome do produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o preço do produto
	 * 
	 * @return o preço do produto
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Retorna a marca do produto
	 * 
	 * @return a marca do produto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Retorna a quantidade do produto
	 * 
	 * @return a quantidade do produto
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Define a quantidade do produto
	 * 
	 * @param quantidade a quantidade do produto
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Cria um construtor vazio da classe Produto.
	 */
	public Produto() {

	}

	/**
	 * Cria uma instância da classe Produto com os parâmetros especificados.
	 *
	 * @param nome       o nome do produto.
	 * @param preco      o preço do produto.
	 * @param marca      a marca do produto.
	 * @param quantidade a quantidade do produto.
	 */
	public Produto(String nome, Double preco, String marca, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.quantidade = quantidade;
	}

	/**
	 * Cria uma cópia do produto especificado.
	 *
	 * @param produto o produto a ser copiado.
	 */
	public Produto(Produto produto) {
		this(produto.getNome(), produto.getPreco(), produto.getMarca(), produto.quantidade);
	}

	// MÉTODOS COMPLEMENTARES

	/**
	 * Retorna uma representação em formato String do produto.
	 *
	 * @return uma string que representa o produto
	 */
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "EUR, marca=" + marca + ", quantidade=" + quantidade
				+ "]";
	}

}
