package pt.tpsi.festa.comesebebes.model;

import java.util.Map;
import java.util.stream.Collectors;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

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
	public String consultar() throws ProductFetchException, NoSuchStoreException {
		Map<String, Long> produtosAgrupados = carrinho.getLista().stream()
				.collect(Collectors.groupingBy(Produto::getNome, Collectors.counting()));

		Map<String, Double> precosPorProduto = carrinho.getLista().stream()
				.collect(Collectors.groupingBy(Produto::getNome, Collectors.summingDouble(Produto::getPreco)));

		String produtosOrdenados = produtosAgrupados.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(entry -> {
					String nomeProduto = entry.getKey();
					long quantidade = entry.getValue();
					double precoUnitario = precosPorProduto.get(nomeProduto) / quantidade;
					return "Item: " + nomeProduto + "\n Quantidade: " + quantidade + "\n Preço: "
							+ (Math.round(precoUnitario * 10000.0) / 10000.0) + "EUR\n--------------------------------";
				}).collect(Collectors.joining("\n"));

		return produtosOrdenados + "\nPreço Total: "
				+ (Math.round(carrinho.getLista().stream().mapToDouble(Produto::getPreco).sum() * 10000.0) / 10000.0)
				+ "EUR";
	}

	public void adicionar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		if (numeroProduto >= 0 && numeroProduto <= carrinho.getProdutos(nome).size()) {
			for (int i = 0; i < quantidade; i++) {
				carrinho.getLista().add(carrinho.getProdutos(nome).get(numeroProduto));
			}
		}
	}

	public void alterar(String nome, int numeroProduto, int quantidade)
			throws NoSuchStoreException, ProductFetchException {
		Map<String, Long> produtosAgrupados = carrinho.getLista().stream()
				.collect(Collectors.groupingBy(Produto::getNome, Collectors.counting()));
		long quantidadeAtual = produtosAgrupados.getOrDefault(carrinho.getProdutos(nome).get(numeroProduto).getNome(),
				0L);

		if (quantidadeAtual < quantidade) {
			adicionar(nome, numeroProduto, (int) (quantidade - quantidadeAtual));
		} else {
			// COMPLETAR
		}
	}

	public void remover(int index) {
		carrinho.getLista().remove(index);
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "Carrinho [carrinho=" + carrinho + "]";
	}

}