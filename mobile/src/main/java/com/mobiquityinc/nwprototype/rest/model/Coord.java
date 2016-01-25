
package com.mobiquityinc.nwprototype.rest.model;

import com.google.gson.annotations.Expose;
import com.mobiquityinc.nwprototype.util.MathUtils;

public class Coord {

    @Expose
    private Double lon;
    @Expose
    private Double lat;

    /**
     * 
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("(")
                .append(MathUtils.round(lat, 2))
                .append(", ")
                .append(MathUtils.round(lon, 2))
                .append(")")
                .toString();
    }
}
