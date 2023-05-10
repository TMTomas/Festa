package pt.tpsi.festa.comesebebes;

import java.util.Iterator;

public class ComesEBebes {

	// 1 - ATRIBUTOS
	
	protected String[] lista; 
	
	// 2 -  ACESSORES
	
	
	
	// 3 - CONSTRUTORES
	
	
	
	// 4 - COMPORTAMENTOS
	
	public void adicionar(String item) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {
				lista[i] = item;
			}
		}
	}
	


	// 5 - METODOS COMPLEMENTARES
	
	
	
}
