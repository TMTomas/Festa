package pt.tpsi.festa.comesebebes;

import pt.tpsi.festa.comesebebes.model.ComesEBebes;

public class Main {

	public static void main(String[] args) {
		ComesEBebes teste = new ComesEBebes();
//		System.out.println(teste.consultar("morango", true));
		teste.adicionar("morango", 99, 3, true);
		teste.adicionar("morango", 99, 4, false);
		teste.adicionar("morango", 99, 1, false);
		teste.alterar(1, 9);
		teste.remover(1);
		System.out.println(teste.consultarCarrinho());

	}

}
