package pt.tpsi.festa.espaco;

import java.util.Calendar;

public class FiltroDia {

	// 1 - ATRIBUTOS
	Calendar c = Calendar.getInstance();
	protected int dia;
	protected int mes;
	protected int ano;

	// 2 - CONSTRUTORES
		// construtor sem parametros com dia, mês e ano ja definidos, dafault
	public FiltroDia() {
		super();
		this.dia = c.get(Calendar.DAY_OF_MONTH);
		this.mes =  c.get(Calendar.MONTH);
		this.ano = c.get(Calendar.YEAR);
	}
		// construtor com parametros caso o utilizador queira saber de um dia específico 
	public FiltroDia(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
		// construtor clone
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
	
	@Override
	public String toString() {
		return "FiltroDia [c=" + c + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + "]";
	}

}
