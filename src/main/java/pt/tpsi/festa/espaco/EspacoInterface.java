package pt.tpsi.festa.espaco;

import pt.tpsi.festa.espaco.model.LocationPlus;

public interface EspacoInterface {

	LocationPlus selecionar(int index);
	
	void pesquisar(String local);

}
