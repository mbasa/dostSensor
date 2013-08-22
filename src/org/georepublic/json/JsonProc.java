package org.georepublic.json;

import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.wink.json4j.*; 
import org.georepublic.bean.*;

public class JsonProc {

    private String url = null;
    private  ArrayList <FloodData> floodDataList = new ArrayList<FloodData>();
    
    public JsonProc(String url) {
        this.setUrl( url );
    }

    public void setUrl( String url ) {
        this.url = url;
    }
    
    public void getJsonData() {
                
        if( this.url == null )
            return;
        
        try {
            URL mUrl = new URL(this.url);

            JSONObject jo  = (JSONObject)JSON.parse(mUrl.openStream());
            JSONObject asg = jo.getJSONObject("asg");
         
            this.setFloodData(asg);
                        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return;
    }

    public void setFloodData(JSONObject asg) {
        Iterator<?> asgKeys = asg.keys();
        String sensor       = new String();
        
        while( asgKeys.hasNext() ) {
            sensor = (String)asgKeys.next();
            
            try {
            
                JSONObject station = asg.getJSONObject( sensor );
                JSONObject vals    = station.getJSONObject("values");
                JSONObject wls     = vals.getJSONObject("wl");
            
                String stationID   = station.getString("station_id");
                String stationTime = station.getString("time");
                double stationLat  = Double.parseDouble(
                        station.getString("lat"));
                double stationLon  = Double.parseDouble(
                        station.getString("lng"));
                double stationVal  = Double.parseDouble(
                        wls.getString("value") );
                            
                FloodData fd = new FloodData();
                fd.setName(stationID);
                fd.setTime(stationTime);
                fd.setValue(stationVal);
                fd.setLat(stationLat);
                fd.setLon(stationLon);
                
                this.floodDataList.add(fd);
            }
            catch( Exception e ) {
                //e.printStackTrace();
            }
        }        
    }
    
    /**
     * @return the floodDataList
     */
    public ArrayList<FloodData> getFloodDataList() {
        return floodDataList;
    }

    /**
     * @param floodDataList the floodDataList to set
     */
    public void setFloodDataList(ArrayList<FloodData> floodDataList) {
        this.floodDataList = floodDataList;
    }
    
}
