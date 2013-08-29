/**
 * 
 */
package org.georepublic.bean;

/**
 * @author mbasa
 *
 */
public class StreamGauge {

    private String name;
    private String time;
    private double value;
    private double lon;
    private double lat;
    private double water_level_change;
    private double time_difference;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }
    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }
    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }
    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }
    /**
     * @return the water_level_change
     */
    public double getWater_level_change() {
        return water_level_change;
    }
    /**
     * @param water_level_change the water_level_change to set
     */
    public void setWater_level_change(double water_level_change) {
        this.water_level_change = water_level_change;
    }
    /**
     * @return the time_difference
     */
    public double getTime_difference() {
        return time_difference;
    }
    /**
     * @param time_difference the time_difference to set
     */
    public void setTime_difference(double time_difference) {
        this.time_difference = time_difference;
    }  
}
