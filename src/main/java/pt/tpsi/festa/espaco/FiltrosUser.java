package pt.tpsi.festa.espaco;

public class FiltrosUser {
	
	// 1 - ATRIBUTOS
	protected String rua;
	protected String pais;
	protected String postalCode;
	protected String localidade;
	// 2 - CONSTRUTORES
	public FiltrosUser() {
		
	}
	// contrutor com parametros 
	public FiltrosUser(String rua, String pais, String postalCode, String localidade) {
		super();
		this.rua = rua;
		this.pais = pais;
		this.postalCode = postalCode;
		this.localidade = localidade;
	}
	// contrutor clone
	public FiltrosUser(FiltrosUser filtrosUser) {
		
	}
	// 3 - GETS E SETS
	public String getRua() {
		return rua;
	}
	public String getPais() {
		return pais;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getLocalidade() {
		return localidade;
	}
	
	// 4 - COMPORTAMENTOS
	// 5 - METODOS COMPLEMENTARES
}
