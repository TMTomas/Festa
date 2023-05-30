package pt.tpsi.festa.espaco.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.EspacoInterface;
import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationPlus;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
import pt.tpsi.festa.execeptions.LocationListException;
import pt.tpsi.festa.execeptions.RequestException;

public class RequestMetreologiaAndLocation implements EspacoInterface {
    
	// 1 - atributos
	/**
	 * Um atributo do tipo MetereologiaRequest, que instancia a classe
	 */
	MetereologiaRequest requestMetreologia;
	/**
	 * Um atributo do tipo OpenStreetMap, que instancia a classe
	 */
    OpenStreetMap requestLocation;
    /**
	 * Um atributo do tipo list, lista criada para guardar os nomes das localizações
	 */
    List<Location> locationList;
    List<LocationPlus> locationListPlus;
    /**
	 * Um atributo do tipo LocationPlus, que instancia a classe
	 */
    List<OpenStreetMapLocation> locations = null;

    MetereologiaModel model;
    // 2 - construtores
    /**
     * Construtor da clase RequestMetereologiaAndLocation e fazer 
     * seus requests atraves delas e guardar a reposta do que foi pedido
     */
    public RequestMetreologiaAndLocation() {
        requestMetreologia = new MetereologiaRequest();
        requestLocation = new OpenStreetMap();
        locationList = new ArrayList<>();
        locationListPlus = new ArrayList<>();
        model = new MetereologiaModel();
    }
    
    // 3 - gets e sets


    public List<Location> getLocationListBase() {
        return locationList;
    }

    public List<LocationPlus> getLocationListPlus() {
        return locationListPlus;
    }
    // 4 - comportamentos
    /**
     * Metódo utilizado para selecionar um local de interese do utilizador
     *
     * @param index o Int serve para receber um index
     * @return retorna o correspondente ao index
     * @throws RequestException o index seja maior que a lista ou a lista não existir ele está la para informar ao utilizador
     */
    @Override
    public LocationPlus selecionar(int index) {
    	if (locationList == null || index > locationList.size() || locationList.isEmpty()) {
			if (index > locationList.size()) {
				throw new LocationListException("index invalida");
			}
			throw new LocationListException("a lista não existe");
		}
        return locationListPlus.get(index);
    }


    /**
     * Este metódo serve para selecionar um nome, o utilizador preenche com um nome
     * o metodo pescorre toda a lista a procura de um nome que de match e o retorna
     * @param name O nome para pesquisar e selecionar na lista
     * @return o nome que foi dito como parametro
     * caso não seja encontrato
     * @throws RequestException informar o erro que ocorreu
     */
	public LocationPlus selecionar(String name) {
    	for (int i = 0; i < locationList.size(); i++) {
			if (locationList.get(i).getNameLocation().toLowerCase().contains(name)) {
				return locationListPlus.get(i);
			}
		}
    	throw new LocationListException("nome não encontrado");
    }
	
    /**
     * this metodo is used to make, the Metrology request that will give the temperature
     * from the respective place that will be search and the
     * @param local this is the local that will be search
     * @return List this is will return a list with all necessary information
     */
    @Override
    public void pesquisar(String local) {
        try {
            locations = requestLocation.search(local);
        } catch (LocationSearchException e) {
            throw new RequestException(e.getMessage());
        }

        for(int i = 0 ; i < locations.size(); i++){
            model = requestMetreologia.createMetrologiaRequest(locations.get(i).getLatitute(), locations.get(i).getLongitude());
            locationListPlus.add(new LocationPlus(locations.get(i).getDisplayName(), locations.get(i).getLatitute(),
                    locations.get(i).getLongitude(), model.getWeather().get(0).getMain() + " "+ model.getWeather().get(0).getDescription(),
                    model.getTemperatura().getTempC(), model.getTemperatura().getMinTempC(),
                    model.getTemperatura().getMaxTempC(), locations.get(i).getType(), locations.get(i).getIcon()));
            locationList.add(new Location(locations.get(i).getDisplayName(),locations.get(i).getLatitute(),
                    locations.get(i).getLongitude(), model.getWeather().get(0).getMain() + " "+ model.getWeather().get(0).getDescription()));
        }
    }

	


    // 5- metodos complementares
    /**
     * Passa a classe para uma forma textual
     */
    @Override
    public String toString() {
        return "RequestMetreologiaAndLocation{" +
                "requestMetreologia=" + requestMetreologia +
                ", requestLocation=" + requestLocation +
                ", locationList=" + locationList +
                ", locations=" + locations +
                ", model=" + model +
                '}';
    }
}
