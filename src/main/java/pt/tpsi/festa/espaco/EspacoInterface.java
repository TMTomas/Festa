package pt.tpsi.festa.espaco;

import pt.tpsi.festa.espaco.model.LocationPlus;
import pt.tpsi.festa.espaco.model.LocationPlus;

import java.util.List;

public interface EspacoInterface {

	LocationPlus selecionar(int index);
	
	List<LocationPlus> pesquisar(String local);

}
