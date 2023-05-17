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
    MetereologiaRequest requestMetreologia;
    OpenStreetMap requestLocation;
    List<Location> locationList;

    Location location;
    public RequestMetreologiaAndLocation() {
        requestMetreologia = new MetereologiaRequest();
        requestLocation = new OpenStreetMap();
        locationList = new ArrayList<>();
    }

    @Override
    public Location selecionar(int index) {
        return locationList.get(index);
    }

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
            location.setNameLocation(locations.get(i).getDisplayName());
            location.setWeather(model.getWeather().get(i).getMain() + " "+ model.getWeather().get(i).getDescription());
            location.setTemperature(model.getTemperatura().getTempC());
            location.setTemperatureMin(model.getTemperatura().getMinTempC());
            location.setTemperatureMax(model.getTemperatura().getMaxTempC());
            location.setLatitude(locations.get(i).getLatitute());
            location.setLongitude(locations.get(i).getLongitude());

            locationList.add(new Location(location.getNameLocation(),location.getLatitude(),location.getLongitude(), location.getWeather(),
                    location.getTemperature(), location.getTemperatureMin(),location.getTemperatureMax()));
        }
        return locationList;
    }
}
