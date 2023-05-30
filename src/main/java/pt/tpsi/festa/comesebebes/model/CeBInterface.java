package pt.tpsi.festa.comesebebes.model;

public interface CeBInterface {

	public String consultar(String produto, boolean isProduto2);

	public void adicionar(String nome, int indiceProduto, int quantidade, boolean isProduto2);

	public void alterar(int indiceNoCarrinho, int quantidade);

	public void remover(int index);
}