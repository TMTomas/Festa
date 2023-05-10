package pt.tpsi.festa.espaco;

import java.util.Calendar;

public class FiltroDia {

	// 1 - ATRIBUTOS
	Calendar c = Calendar.getInstance();
	protected int dia;
	protected int mes;
	protected int ano;

	// 2 - CONSTRUTORES
	
	public FiltroDia() {
		super();
		this.dia = c.get(Calendar.DAY_OF_MONTH);
		this.mes =  c.get(Calendar.MONTH);
		this.ano = c.get(Calendar.YEAR);
	}

	public FiltroDia(FiltroDia filtrodia) {
		
	}
	// 3 - GETS E SETS

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
	
	// 4 - COMPORTAMENTOS

	// 5 - METODOS COMPLEMENTARES

}
