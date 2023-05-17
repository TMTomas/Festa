package pt.tpsi.festa.espaco.http;

import pt.brunojesus.locationsearch.api.OpenStreetMap;
import pt.brunojesus.locationsearch.exception.LocationSearchException;
import pt.brunojesus.locationsearch.openstreetmap.model.OpenStreetMapLocation;
import pt.tpsi.festa.espaco.model.MetereologiaModel;

import java.util.ArrayList;
import java.util.List;

public class RequestMetreologiaAndLocation {
    MetereologiaRequest requestMetreologia;
    OpenStreetMap requestLocation;

    Location location;
    public RequestMetreologiaAndLocation() {
        requestMetreologia = new MetereologiaRequest();
        requestLocation = new OpenStreetMap();
    }

    public List<Location> createLocation(String searchExpression){
        List<Location> locationList = new ArrayList<>();
        List<OpenStreetMapLocation> locations = null;
        try {
            locations = requestLocation.search(searchExpression);
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
