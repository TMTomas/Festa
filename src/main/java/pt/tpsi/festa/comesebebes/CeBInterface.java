package pt.tpsi.festa.comesebebes;

public interface CeBInterface {
		
	public void consultar(/* mapper de produtos, quantidades e preços */);
	public void adicionar(int produto, int quantidade);
	public void alterar(int quantidade); 
	public void remover(int index);	
}