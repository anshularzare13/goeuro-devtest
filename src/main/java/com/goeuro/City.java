package com.goeuro;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Anshul on 06/12/15.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = {"_id", "name", "type", "latitude", "longitude"})
public class City implements Serializable {

    @JsonProperty("_id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("geo_position")
    private GeoLocation location;

    @JsonGetter("_id")
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getLatitude() {
            return location.getLatitude();
    }

    public Double getLongitude() {
            return location.getLongitude();
    }


    private static class GeoLocation {

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("latitude")
        private double latitude;

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%f,%f", id, name, type, getLatitude(),
                getLongitude());
    }

}
