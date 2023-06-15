package pt.tpsi.festa.espaco;

import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationPlus;

import java.util.List;

public interface EspacoInterface {

	LocationPlus selecionar(int index);
	
	void pesquisar(String local);

}
