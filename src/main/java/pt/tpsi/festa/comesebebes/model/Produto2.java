package pt.tpsi.festa.comesebebes.model;

public class Produto2 extends Produto {
	// ATRIBUTOS
	protected String url;
	protected String imagem;
	protected boolean disponivel;

	// ACESSORES
	public String getUrl() {
		return url;
	}

	public String getImagem() {
		return imagem;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	// CONSTRUTOR 1 - default
	public Produto2() {

	}

	// CONSTRUTOR 2 - com parâmetros
	public Produto2(String nome, Double preco, String marca, int quantidade, String url, String imagem,
			boolean disponivel) {
		super(nome, preco, marca, quantidade);
		this.url = url;
		this.imagem = imagem;
		this.disponivel = disponivel;
	}

	// CONSTRUTOR 3 - cópia
	public Produto2(Produto2 produto) {
		this(produto.getNome(), produto.getPreco(), produto.getMarca(), produto.getQuantidade(), produto.getUrl(),
				produto.getImagem(), produto.isDisponivel());
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "Produto2 [nome=" + nome + ", preco=" + preco + "EUR, marca=" + marca + ", quantidade=" + quantidade
				+ ", url=" + url + ", imagem=" + imagem + ", disponivel=" + disponivel + "]";
	}
}
