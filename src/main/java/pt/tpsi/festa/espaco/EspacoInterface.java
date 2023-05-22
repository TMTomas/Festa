package pt.tpsi.festa.espaco;

import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationLessDetails;

import java.util.List;

public interface EspacoInterface {

	Location selecionar(int index);

	LocationLessDetails selecionarLess(int index);
		
	
	List<Location> pesquisar(String local);

	List<LocationLessDetails> pesquisarLessDetails(String serachExpression);
}
