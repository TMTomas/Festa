package pt.tpsi.festa.comesebebes.model;

public class Produto {
	// ATRIBUTOS
	protected String nome;
	protected Double preco;
	protected String marca;

	// ACESSORES
	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public String getMarca() {
		return marca;
	}

	// CONSTRUTOR 1 - default
	public Produto() {

	}

	// CONSTRUTOR 2 - com parâmetros
	public Produto(String nome, Double preco, String marca) {
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}

	// CONSTRUTOR 3 - cópia
	public Produto(Produto produto) {
		this(produto.getNome(), produto.getPreco(), produto.getMarca());
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + "EUR, marca=" + marca + "]";
	}
}
