package pt.tpsi.festa.comesebebes.api;

import java.util.ArrayList;
import java.util.List;
import pt.brunojesus.productsearch.api.ProductSearch;
import pt.brunojesus.productsearch.api.model.Product;
import pt.brunojesus.productsearch.api.model.Store;
import pt.brunojesus.productsearch.exception.NoSuchStoreException;
import pt.brunojesus.productsearch.exception.ProductFetchException;
import pt.tpsi.festa.comesebebes.model.Produto;

public class ApiProdutos {
    private ProductSearch productSearch;

    public ApiProdutos() {
        productSearch = new ProductSearch();
    }

    public List<Produto> buscarProdutos(String nome) {
        List<Produto> produtos = new ArrayList<>();
        try {
            List<Product> apiProdutos = productSearch.search(Store.PINGO_DOCE, nome);
            for (Product apiProduto : apiProdutos) {
                Produto produto = new Produto(apiProduto.getName(), apiProduto.getCurrentPrice(), apiProduto.getBrand(), 0);
                produtos.add(produto);
            }
        } catch (NoSuchStoreException | ProductFetchException e) {
            // Trate a exceção aqui (exemplo: log, mensagem de erro, etc.)
            e.printStackTrace();
        } 
        return produtos;
    }
}

