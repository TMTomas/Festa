package pt.tpsi.festa.comesebebes.model;

/**
 * Classe que lida com os Comes e Bebes da festa.
 * 
 * @author André, Danilo, Duarte e Rodrigo
 * @version 1.0.0
 */
public class ComesEBebes implements CeBInterface {
	// ATRIBUTOS
	private Carrinho carrinho;
	private ListaDeProdutos listaDeProdutos;

	// ACESSORES

	/**
	 * Obtém a classe Carrinho.
	 *
	 * @return o Carrinho.
	 */
	public Carrinho getCarrinho() {
		return carrinho;
	}

	/**
	 * Obtém a classe ListaDeProdutos.
	 *
	 * @return a ListaDeProdutos.
	 */
	public ListaDeProdutos getListaDeProdutos() {
		return listaDeProdutos;
	}

	/**
	 * Construtor vazio da classe ComesEBebes.
	 *
	 */
	public ComesEBebes() {
		this.carrinho = new Carrinho();
		this.listaDeProdutos = new ListaDeProdutos();
	}

	/**
	 * Cria a classe ComesEBebes com carrinho e lista de compras ja especificado
	 *
	 * @param carrinho        o carrinho a ser utilizado
	 * @param listaDeProdutos a lista de produtos a ser utilizada
	 */
	public ComesEBebes(Carrinho carrinho, ListaDeProdutos listaDeProdutos) {
		super();
		this.carrinho = carrinho;
		this.listaDeProdutos = listaDeProdutos;
	}

	// COMPORTAMENTOS
	@Override
	/**
	 * Consulta a lista de produtos com base em um nome.
	 *
	 * @param nome o nome dos produtos a serem consultados.
	 * @return uma string que contém informações dos produtos consultados.
	 */
	public String consultar(String produto, boolean isProduto2) {
		return listaDeProdutos.consultar(produto, isProduto2);

	}

	/**
	 * Consulta os produtos no carrinho e retorna uma representação em string.
	 *
	 * @return uma string contendo os produtos no carrinho, seus atributos e o preço
	 *         total
	 */
	public String consultarCarrinho() {
		return carrinho.consultar();

	}

	/**
	 * Adiciona um produto ao carrinho.
	 *
	 * @param nome          o nome do produto
	 * @param indiceProduto o índice do produto na lista de produtos da API
	 * @param quantidade    a quantidade a ser adicionada ao carrinho
	 * @param isProduto2    define se deve se adicionar um produto da classe
	 *                      Produto2 (mais detalhado) ou Produto
	 */
	@Override
	public void adicionar(String nome, int indiceProduto, int quantidade, boolean isProduto2) {
		carrinho.adicionar(nome, indiceProduto, quantidade, isProduto2);

	}

	/**
	 * Altera a quantidade de um produto no carrinho.
	 *
	 * @param indiceNoCarrinho o indice do produto no carrinho
	 * @param quantidade       a nova quantidade do produto
	 */
	@Override
	public void alterar(int indiceNoCarrinho, int quantidade) {
		carrinho.alterar(indiceNoCarrinho, quantidade);
	}

	/**
	 * Diminui a quantidade de um produto, e o remove do carrinho quando a
	 * quantidade chegar a 0.
	 *
	 * @param index o índice do produto no carrinho
	 */
	@Override
	public void remover(int index) {
		carrinho.remover(index);

	}

	/**
	 * Retorna uma representação em formato de string do ComesEBebes.
	 *
	 * @return uma string que representa o objeto de ComesEBebes
	 */
	// MÉTODOS COMPLEMENTARES
	@Override
	public String toString() {
		return "ComesEBebes [carrinho=" + carrinho + ", listaDeProdutos=" + listaDeProdutos + "]";
	}

}
