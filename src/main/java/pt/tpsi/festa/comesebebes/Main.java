package pt.tpsi.festa.comesebebes;

import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class Main {

	public static void main(String[] args) {
		ComesEBebes comes = new ComesEBebes();
		System.out.println(comes.consultar("morango")); // consulta morangos da lista da LOJA (pingo doce)

		comes.adicionar("morango", 0, 2); // adiciona o morango de indice 2 da LOJA ao CARRINHO (lista de compras)
		// no carrinho, este sera o produto de indice 0

		comes.alterar(0, 3); // altera a quantidade do produto de indice 0 do CARRINHO (morango)

		comes.remover(0);   // diminui em 1 a quantidade do morango, que ficara com 2 no atributo quantidade.
							// caso remova até a quantidade ser 0, o produto deixará de existir no Array 
							//do carrinho

		System.out.println(comes.getCarrinho().consultar()); // consulta os produtos do CARRINHO

	}

}
