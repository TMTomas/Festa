package pt.tpsi.festa.comesebebes;

public interface CeBInterface {
		
	public void consultar(String produto);
	public void adicionar(int produto, int quantidade);
	public void alterar(int quantidade); 
	public void remover(int index);	
}