package pt.tpsi.festa.comesebebes.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import pt.tpsi.festa.comesebebes.api.ApiProdutos;

/**
 * Classe que representa um carrinho de compras que possui produtos
 * 
 * @see ListaDeProdutos
 */
public class Carrinho {
	// ATRIBUTOS
	protected List<Produto> listaDeCompras = new ListaDeProdutos().getLista();
	protected ApiProdutos apiProdutos = new ApiProdutos();

	// ACESSORES

	/**
	 * Obtém a lista de compras.
	 *
	 * @return A lista de compras.
	 */
	public List<Produto> getListaDeCompras() {
		return listaDeCompras;
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
	public Carrinho(List<Produto> listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

	/**
	 * Cria uma cópia do carrinho de compras especificado.
	 *
	 * @param carrinho o carrinho de compras a ser copiado
	 */
	public Carrinho(Carrinho carrinho) {
		this(carrinho.getListaDeCompras());
	}

	// COMPORTAMENTOS

	/**
	 * Consulta os produtos no carrinho e retorna uma representação em string.
	 *
	 * @return uma string contendo os produtos no carrinho, seus atributos e o preço
	 *         total
	 */
	public String consultar() {
		String produtosOrdenados = listaDeCompras.stream().map(produto -> {
			String nomeProduto = produto.getNome();
			String marca = produto.getMarca();
			double precoUnitario = produto.getPreco();
			int quantidade = produto.getQuantidade();
			String atributosExtras = "";

			if (produto instanceof Produto2) {
				Produto2 produto2 = (Produto2) produto;
				String url = produto2.getUrl();
				String imagem = produto2.getImagem();
				atributosExtras = "\n Url: " + url + "\n Imagem: " + imagem;
			}

			return "Item: " + nomeProduto + "\n Marca: " + marca + "\n Preço Unitário: "
					+ (Math.round(precoUnitario * 10000.0) / 10000.0) + "EUR" + "\n Quantidade: " + quantidade
					+ atributosExtras + "\n--------------------------------\n";
		}).collect(Collectors.joining("\n"));

		double precoTotal = (Math.round(
				listaDeCompras.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).sum()
						* 10000.0)
				/ 10000.0);

		return produtosOrdenados + "\nPreço Total: " + precoTotal + "EUR";
	}

	/**
	 * Adiciona um produto ao carrinho.
	 *
	 * @param nome          o nome do produto
	 * @param indiceProduto o índice do produto na lista de produtos da API
	 * @param quantidade    a quantidade a ser adicionada ao carrinho
	 * @param isProduto2    define se deve se adicionar um produto da classe
	 *                      Produto2 (mais detalhado) ou Produto
	 */
	public void adicionar(String nome, int indiceProduto, int quantidade, boolean isProduto2) {

		if (indiceProduto >= 0 && indiceProduto < apiProdutos.buscarProdutos(nome).size()) {
			List<Produto> produtos = apiProdutos.buscarProdutos(nome);
			Produto produtoSelecionado = produtos.get(indiceProduto);

			Optional<Produto> produtoExistente = listaDeCompras.stream()
					.filter(produto -> produto.getNome().equals(produtoSelecionado.getNome()) && isProduto2)
					.findFirst();

			produtoExistente.ifPresentOrElse(produto -> produto.setQuantidade(produto.getQuantidade() + quantidade),
					() -> {
						Produto novoProduto;
						if (isProduto2) {
							novoProduto = new Produto2((Produto2) produtoSelecionado);
						} else {
							novoProduto = new Produto(produtoSelecionado);
						}
						novoProduto.setQuantidade(quantidade);
						listaDeCompras.add(novoProduto);
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
		if (indiceNoCarrinho >= 0 && indiceNoCarrinho < listaDeCompras.size()) {
			Produto produto = listaDeCompras.get(indiceNoCarrinho);
			produto.setQuantidade(quantidade);
			if (quantidade <= 0) {
				listaDeCompras.remove(produto);
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
		if (index >= 0 && index < listaDeCompras.size()) {
			Produto produto = listaDeCompras.get(index);

			if (produto.getQuantidade() > 1) {
				produto.setQuantidade(produto.getQuantidade() - 1);
			} else {
				listaDeCompras.remove(index);
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
		return "Carrinho [carrinho=" + listaDeCompras + "]";
	}
}