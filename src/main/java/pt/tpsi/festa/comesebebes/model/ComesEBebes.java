package pt.tpsi.festa.comesebebes.model;

public class ComesEBebes implements CeBInterface {
	// ATRIBUTOS
	private Carrinho carrinho;
	private ListaDeProdutos listaDeProdutos;

	// ACESSORES
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public ListaDeProdutos getListaDeProdutos() {
		return listaDeProdutos;
	}

	// CONSTRUTOR 1 - default
	public ComesEBebes() {
		this.carrinho = new Carrinho();
		this.listaDeProdutos = new ListaDeProdutos();
	}

	public ComesEBebes(Carrinho carrinho, ListaDeProdutos listaDeProdutos) {
		super();
		this.carrinho = carrinho;
		this.listaDeProdutos = listaDeProdutos;
	}

	// COMPORTAMENTOS
	@Override
	public String consultar(String produto) {
		return listaDeProdutos.consultar(produto);

	}

	@Override
	public void adicionar(String nome, int indiceProduto, int quantidade) {
		carrinho.adicionar(nome, indiceProduto, quantidade);

	}

	@Override
	public void alterar(int indiceNoCarrinho, int quantidade) {
		carrinho.alterar(indiceNoCarrinho, quantidade);
	}

	@Override
	public void remover(int index) {
		carrinho.remover(index);

	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ComesEBebes [carrinho=" + carrinho + ", listaDeProdutos=" + listaDeProdutos + "]";
	}

}
