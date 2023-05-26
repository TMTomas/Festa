package pt.tpsi.festa.comesebebes.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComesEBebesTest {

    private ComesEBebes comesEBebes;

    @BeforeEach
    public void setUp() {
        Carrinho carrinho = new Carrinho();
        ListaDeProdutos listaDeProdutos = new ListaDeProdutos();
        comesEBebes = new ComesEBebes(carrinho, listaDeProdutos);
    }


    @Test
    public void testAdicionar() {
        String nome = "Produto1";
        int indiceProduto = 0;
        int quantidade = 2;
        boolean isProduto2 = false;

        comesEBebes.adicionar(nome, indiceProduto, quantidade, isProduto2);

        assertEquals(1, comesEBebes.getCarrinho().getListaDeCompras().size());
        assertEquals(2, comesEBebes.getCarrinho().getListaDeCompras().get(0).getQuantidade());
    }

    @Test
    public void testAlterar() {
        Carrinho carrinho = comesEBebes.getCarrinho();
        Produto produto = new Produto("Produto1", 10.0, "Marca1", 3);
        carrinho.getListaDeCompras().add(produto);

        int indiceNoCarrinho = 0;
        int quantidade = 5;

        comesEBebes.alterar(indiceNoCarrinho, quantidade);

        assertEquals(quantidade, carrinho.getListaDeCompras().get(0).getQuantidade());
    }

    @Test
    public void testRemover() {
        Carrinho carrinho = comesEBebes.getCarrinho();
        Produto produto = new Produto("Produto1", 10.0, "Marca1", 1);
        carrinho.getListaDeCompras().add(produto);

        int index = 0;

        comesEBebes.remover(index);

        assertTrue(carrinho.getListaDeCompras().isEmpty());
    }
}
