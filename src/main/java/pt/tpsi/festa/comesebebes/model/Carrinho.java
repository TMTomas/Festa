package pt.tpsi.festa.comesebebes.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe que representa um carrinho de compras que possui produtos
 * 
 * @see ListaDeProdutos
 */
public class Carrinho {
	// ATRIBUTOS
	protected ListaDeProdutos carrinho = new ListaDeProdutos();

	// ACESSORES

	/**
	 * Obtém o carrinho de compras.
	 *
	 * @return O carrinho de compras.
	 */
	public ListaDeProdutos getCarrinho() {
		return carrinho;
	}

	/**
	 * Cria um carrinho de compras vazio.
	 */
	public Carrinho() {

	}

	/**
	 * Cria um carrinho de compras com uma lista de produtos especificada.
	 *
	 * @param carrinho a lista de produtos a ser atribuída ao carrinho
	 */
	public Carrinho(ListaDeProdutos carrinho) {
		this.carrinho = carrinho;
	}

	/**
	 * Cria uma cópia do carrinho de compras especificado.
	 *
	 * @param carrinho o carrinho de compras a ser copiado
	 */
	public Carrinho(Carrinho carrinho) {
		this(carrinho.getCarrinho());
	}

	// COMPORTAMENTOS

	/**
	 * Consulta os produtos no carrinho e retorna uma representação em string.
	 *
	 * @return uma string contendo os produtos no carrinho, seus atributos e o preço
	 *         total
	 */
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

	/**
	 * Adiciona um produto ao carrinho.
	 *
	 * @param nome          o nome do produto
	 * @param indiceProduto o índice do produto na lista de produtos da API
	 * @param quantidade    a quantidade a ser adicionada ao carrinho
	 */
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

	/**
	 * Altera a quantidade de um produto no carrinho.
	 *
	 * @param indiceNoCarrinho o indice do produto no carrinho
	 * @param quantidade       a nova quantidade do produto
	 */
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

	/**
	 * Diminui a quantidade de um produto, e o remove do carrinho quando a
	 * quantidade chegar a 0.
	 *
	 * @param index o índice do produto no carrinho
	 */
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

	/**
	 * Retorna uma representação em formato de string do objeto Carrinho.
	 *
	 * @return uma string que representa o objeto Carrinho
	 */
	@Override
	public String toString() {
		return "Carrinho [carrinho=" + carrinho + "]";
	}
}