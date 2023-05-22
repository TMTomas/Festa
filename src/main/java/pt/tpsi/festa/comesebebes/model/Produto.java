package pt.tpsi.festa.comesebebes.model;

public class Produto {
	// ATRIBUTOS
	String nome;
	int numeroProduto;

	// ACESSORES
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroProduto() {
		return numeroProduto;
	}

	public void setNumeroProduto(int numeroProduto) {
		this.numeroProduto = numeroProduto;
	}

	// CONSTRUTOR 1 - default
	public Produto() {

	}

	// CONSTRUTOR 2 - com parâmetros
	public Produto(String nome, int numeroProduto) {
		super();
		this.nome = nome;
		this.numeroProduto = numeroProduto;
	}

	// COMPORTAMENTOS

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", numeroProduto=" + numeroProduto + "]";
	}
}
