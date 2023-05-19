package pt.tpsi.festa.espaco.http;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.EspacoInterface;
import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

import java.util.ArrayList;
import java.util.List;

public class RequestMetreologiaAndLocation implements EspacoInterface {
    
	// 1 - atributos
	MetereologiaRequest requestMetreologia;
    OpenStreetMap requestLocation;
    List<Location> locationList;

    Location location;
    
    // 2 - construtores
    
    public RequestMetreologiaAndLocation() {
        requestMetreologia = new MetereologiaRequest();
        requestLocation = new OpenStreetMap();
        locationList = new ArrayList<>();
    }
    
    // 3 - gets e sets
    
    // 4 - comportamentos
    @Override
    public Location selecionar(int index) {
        return locationList.get(index);
    }

    /**
     * this metodo is used to make, the Metrology request that will give the temperature
     * from the respective place that will be search and the
     * @param local this is the local that will be search
     * @return List this is will return a list with all necessary information
     */
    @Override
    public List<Location> pesquisar(String local) {
        List<OpenStreetMapLocation> locations = null;
        try {
            locations = requestLocation.search(local);
        } catch (LocationSearchException e) {
            throw new RuntimeException(e.getMessage());
        }

        for(int i = 0 ; i < locations.size(); i++){
            MetereologiaModel model = requestMetreologia.createMetrologiaRequest(locations.get(i).getLatitute(), locations.get(i).getLongitude());
            locationList.add(new Location(locations.get(i).getDisplayName(),locations.get(i).getLatitute(),
                    locations.get(i).getLongitude(), model.getWeather().get(i).getMain() + " "+ model.getWeather().get(i).getDescription(),
                    model.getTemperatura().getTempC(), model.getTemperatura().getMinTempC(),model.getTemperatura().getMaxTempC()));
        }
        
        return locationList;
    }
    
    // 5- metodos complementares
}
