package pt.tpsi.festa.espaco.http;

import pt.tpsi.festa.espaco.EspacoInterface;
import pt.tpsi.festa.espaco.execeptions.LocationListException;
import pt.tpsi.festa.espaco.execeptions.RequestException;
import pt.tpsi.festa.espaco.model.Location;
import pt.tpsi.festa.espaco.model.LocationPlus;
import pt.tpsi.festa.espaco.model.MetereologiaModel;
import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
public class RequestMetreologiaAndLocation implements EspacoInterface {

    // 1 - atributos
    private final MetereologiaRequest requestMetreologia;

    private final OpenStreetMap requestLocation;

    private final List<Location> locationList;

    private final List<LocationPlus> locationListPlus;

    private List<OpenStreetMapLocation> locations = null;

    private MetereologiaModel model;

    // 2 - construtores
    /**
     * Constructor of the RequestMetereologyAndLocation class and do
     *  your requests through them and save the response of what was requested
     */
    public RequestMetreologiaAndLocation() {
        requestMetreologia = new MetereologiaRequest();
        requestLocation = new OpenStreetMap();
        locationList = new ArrayList<>();
        locationListPlus = new ArrayList<>();
        model = new MetereologiaModel();
    }

    // 3 - gets e sets

    /**
     * Will give a list with only the basic data
     * @return locationList
     */
    public List<Location> getLocationListBase() {
        return locationList;
    }

    /**
     * Will give a list with all information of the request
     * @return locationListPlus
     */
    public List<LocationPlus> getLocationListPlus() {
        return locationListPlus;
    }
    // 4 - comportamentos
    /**
     * Method used to select a user's place of interest by index
     *
     * @param index Int serves to receive an index
     * @return LocationPlus returns the corresponding to the index
     * @throws RequestException if the index is greater than the list or the list does not exist it is there to inform the user
     */
    @Override
    public LocationPlus selecionar(int index) {
        if (index > locationList.size() || locationList.isEmpty()) {
            if (index > locationList.size()) {
                throw new LocationListException("index invalida");
            }
            throw new LocationListException("a lista não existe");
        }
        return locationListPlus.get(index);
    }


    /**
     * This method serves to select a name, the user fills in a name
     * the method searches the entire list looking for a name until it matches and it will return
     *
     * @param name The name to search and select from the list
     * @return LocationPlus Found LocationPlus type object
     *
     * @throws RequestException will inform the user if was not found
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
     * this method is used to make, the Metrology request that will give the temperature
     * from the respective place that will be search and the
     * @param local this is the local that will be search
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
     * Convert the class to a textual form
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
