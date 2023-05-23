package pt.tpsi.festa.comesebebes.model;

import java.util.ArrayList;
import java.util.List;
import pt.tpsi.festa.comesebebes.api.ApiProdutos;

public class ListaDeProdutos {
	// ATRIBUTOS
	protected List<Produto> lista;
	protected ApiProdutos apiProdutos;

	// ACESSORES
	public List<Produto> getLista() {
		return lista;
	}

	public List<Produto> getLista(String nome) {
		lista.addAll(apiProdutos.buscarProdutos(nome));
		return lista;
	}

	public ApiProdutos getApiProdutos() {
		return apiProdutos;
	}

	// CONSTRUTOR 1 - default
	public ListaDeProdutos() {
		lista = new ArrayList<>();
		apiProdutos = new ApiProdutos();
	}

	// CONSTRUTOR 2 - com parâmetros
	public ListaDeProdutos(List<Produto> lista) {
		this.lista = lista;
		apiProdutos = new ApiProdutos();
	}

	// CONSTRUTOR 3 - cópia
	public ListaDeProdutos(ListaDeProdutos lista) {
		this(lista.getLista());
	}

	// COMPORTAMENTOS
	public String consultar(String nome) {
		List<Produto> produtos = apiProdutos.buscarProdutos(nome);
		lista.addAll(produtos);

		String resultado = "";
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			resultado += "Índice " + (i) + ":\n";
			resultado += "Nome: " + produto.getNome() + "\n";
			resultado += "Preço: " + produto.getPreco() + "EUR" + "\n";
			resultado += "Preço: " + produto.getMarca() + "\n";
			resultado += "--------------------------------\n";
		}

		return resultado;
	}

	public Produto pesquisarProduto(int index) {
		return lista.get(index);
	}

	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ListaDeProdutos [lista=" + lista + "]";
	}
}
