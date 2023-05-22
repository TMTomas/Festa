package pt.tpsi.festa.espaco.model;

import lombok.Data;

@Data
public class LocationLessDetails {
    private String nameLocation;
    private String latitude;
    private String longitude;
    private String weather;

    public LocationLessDetails() {
    }

    public LocationLessDetails(String nameLocation, String latitude, String longitude, String weather) {
        this.nameLocation = nameLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
    }
}
