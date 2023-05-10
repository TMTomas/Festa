package pt.tpsi.festa.espaco;

public class Filtros {
	
	// 1 - ATRIBUTOS
	protected String rua;
	protected String pais;
	protected String postalCode;
	protected String localidade;
	// 2 - CONSTRUTORES
	public void filtros() {
		
	}
	// contrutor com parametros 
	public Filtros(String rua, String pais, String postalCode, String localidade) {
		super();
		this.rua = rua;
		this.pais = pais;
		this.postalCode = postalCode;
		this.localidade = localidade;
	}
	// contrutor clone
	public void filtros(Filtros filtros) {
		
	}
	// 3 - GETS E SETS
	// 4 - COMPORTAMENTOS
	// 5 - METODOS COMPLEMENTARES
}
