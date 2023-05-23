package pt.tpsi.festa.comesebebes.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrinho {
	// ATRIBUTOS
	protected ListaDeProdutos carrinho = new ListaDeProdutos();

	// ACESSORES
	public ListaDeProdutos getCarrinho() {
		return carrinho;
	}

	// CONSTRUTOR 1 - default
	public Carrinho() {

	}

	// CONSTRUTOR 2 - com parametros
	public Carrinho(ListaDeProdutos carrinho) {
		this.carrinho = carrinho;
	}

	// CONSTRUTOR 3 - cópia
	public Carrinho(Carrinho carrinho) {
		this(carrinho.getCarrinho());
	}

	// COMPORTAMENTOS
	public String consultar() {
		List<Produto> lista = carrinho.getLista();

		String produtosOrdenados = lista.stream().map(produto -> {
			String nomeProduto = produto.getNome();
			String marca = produto.getMarca();
			double precoUnitario = produto.getPreco();
			int quantidade = produto.getQuantidade();
			return "Item: " + nomeProduto + "\n Marca: " + marca + "\n Preço Unitário: "
					+ (Math.round(precoUnitario * 10000.0) / 10000.0) + "EUR" + "\n Quantidade: " + quantidade
					+ "\n--------------------------------";
		}).collect(Collectors.joining("\n"));

		double precoTotal = lista.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).sum();

		return produtosOrdenados + "\nPreço Total: " + (Math.round(precoTotal * 10000.0) / 10000.0) + "EUR";
	}

	public void adicionar(String nome, int indiceProduto, int quantidade) {
		List<Produto> lista = carrinho.getLista();

		if (indiceProduto >= 0 && indiceProduto < carrinho.getApiProdutos().buscarProdutos(nome).size()) {
			List<Produto> produtos = carrinho.getApiProdutos().buscarProdutos(nome);
			Produto produtoSelecionado = produtos.get(indiceProduto);

			Optional<Produto> produtoExistente = lista.stream()
					.filter(produto -> produto.getNome().equals(produtoSelecionado.getNome())).findFirst();

			produtoExistente.ifPresentOrElse(produto -> produto.setQuantidade(produto.getQuantidade() + quantidade),
					() -> {
						Produto novoProduto = new Produto(produtoSelecionado);
						novoProduto.setQuantidade(quantidade);
						lista.add(novoProduto);
					});
		}
	}

	public void alterar(int indiceNoCarrinho, int quantidade) {
		List<Produto> lista = carrinho.getLista();

		if (indiceNoCarrinho >= 0 && indiceNoCarrinho < lista.size()) {
			Produto produto = lista.get(indiceNoCarrinho);
			produto.setQuantidade(quantidade);
			if (quantidade <= 0) {
				lista.remove(produto);
			}
		}
	}

	public void remover(int index) {
		List<Produto> lista = carrinho.getLista();

		if (index >= 0 && index < lista.size()) {
			Produto produto = lista.get(index);

			if (produto.getQuantidade() > 1) {
				produto.setQuantidade(produto.getQuantidade() - 1);
			} else {
				lista.remove(index);
			}
		}
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "Carrinho [carrinho=" + carrinho + "]";
	}
}