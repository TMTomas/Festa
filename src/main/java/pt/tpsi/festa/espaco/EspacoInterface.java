package pt.tpsi.festa.espaco;

import pt.tpsi.festa.espaco.model.Location;

import java.util.List;

public interface EspacoInterface {

	Location selecionar(int index);
	
	List<Location> pesquisar(String local);

}
