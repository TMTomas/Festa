package pt.tpsi.festa.comesebebes;

import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class Main {

	public static void main(String[] args) {
		ComesEBebes comes = new ComesEBebes();
//		System.out.println(comes.consultar("morango")); // consulta morangos da lista da LOJA (pingo doce)

		comes.adicionar("morango", 2, 3, true); // adiciona o morango de indice 2 da LOJA ao CARRINHO (lista de compras)
		// no carrinho, este sera o produto de indice 0 e sera da classe Produto2, com
		// mais detalhes

		comes.adicionar("morango", 2, 2, false); // adiciona o mesmo morango que o anterior, porem com menos 
		//detalhes, portanto, é um objeto diferente.

		comes.alterar(1, 6); // altera a quantidade do produto de indice 1 do CARRINHO (morango do produto1)

//		comes.remover(0); // diminui em 1 a quantidade do morango no atributo
		// quantidade.
		// caso remova até a quantidade ser 0, o produto deixará de existir no Array
		// do carrinho

		System.out.println(comes.getCarrinho().consultar()); // consulta os produtos do CARRINHO

	}

}
