package pt.tpsi.festa.comesebebes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;

public class ComesEBebes {
    // ATRIBUTOS
    protected List<Product> carrinho = new ArrayList<Product>();
    protected List<Product> baseDeDados = new ArrayList<Product>();

    // ACESSORES
    public String getCarrinho() {
    	Map<String, Long> produtosAgrupados = carrinho.stream()
    	        .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    	
    	Map<String, Double> precosPorProduto = carrinho.stream()
    	        .collect(Collectors.groupingBy(Product::getName, Collectors.summingDouble(Product::getCurrentPrice)));
    	
		String produtosOrdenados = produtosAgrupados.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .map(entry -> {
            String nomeProduto = entry.getKey();
            long quantidade = entry.getValue();
            double precoUnitario = precosPorProduto.get(nomeProduto) / quantidade;
            return "Item: " + nomeProduto + "\n Quantidade: " + quantidade + "\n Preço: " + (Math.round(precoUnitario * 10000.0) / 10000.0)
                    + "EUR\n--------------------------------";
        })
        .collect(Collectors.joining("\n"));
		
		return produtosOrdenados + "\nPreço Total: " + (Math.round(carrinho.stream().mapToDouble(Product::getCurrentPrice).sum()* 10000.0) / 10000.0) + "EUR";

    }

    public void setCarrinho(List<Product> carrinho) {
        this.carrinho = carrinho;
    }

    public List<Product> getBaseDeDados() {
        return baseDeDados;
    }

    // COMPORTAMENTOS
    public String buscarProduto(String nome) throws ProductFetchException, NoSuchStoreException {
        ProductSearch productSearch = new ProductSearch();
        List<Product> produtos = productSearch.search(Store.PINGO_DOCE, nome);

        // Adicionar produtos à base de dados
        baseDeDados.addAll(produtos);

        String resultado = "";
        for (int i = 0; i < 50 && i < produtos.size(); i++) {
            Product produto = produtos.get(i);
            resultado += "Produto " + (i + 1) + ":\n";
            resultado += "Nome: " + produto.getName() + "\n";
            resultado += "Preço: " + produto.getCurrentPrice() + produto.getCurrency() + "\n";
            resultado += "--------------------------------\n";
        }

        return resultado;
    }

    public void adicionarProduto(String nome, int numeroProduto) throws ProductFetchException, NoSuchStoreException {
        ProductSearch productSearch = new ProductSearch();
        List<Product> produtos = productSearch.search(Store.PINGO_DOCE, nome);
        if (numeroProduto >= 1 && numeroProduto <= produtos.size()) {
            carrinho.add(produtos.get(numeroProduto - 1));
        }
    }
    
    public void adicionarProduto(String nome, int numeroProduto, int quantidade) throws ProductFetchException, NoSuchStoreException {
        ProductSearch productSearch = new ProductSearch();
        List<Product> produtos = productSearch.search(Store.PINGO_DOCE, nome);
        if (numeroProduto >= 1 && numeroProduto <= produtos.size()) {
        	for (int i = 0; i < quantidade; i++) {
				carrinho.add(produtos.get(numeroProduto - 1));
			}
        }
    }

    public void removerProduto(int id) {
        carrinho.remove(id);
    }

    // METODOS COMPLEMENTARES
    @Override
    public String toString() {
        return "ComesEBebes [carrinho=" + carrinho + "]";
    }
}