package org.georepublic.json;

import java.net.*;
import org.apache.wink.json4j.*; 
import org.georepublic.bean.*;

public class JsonProc {

    private String url = null;
    
    public JsonProc(String url) {
        this.setUrl( url );
    }

    public void setUrl( String url ) {
        this.url = url;
    }
    
    public FloodData getJsonData() {
        
        FloodData floodData = null;
        
        if( this.url == null )
            return floodData;
        
        try {
            URL mUrl = new URL(this.url);

            JSONObject jo = (JSONObject)JSON.parse(mUrl.openStream());
            
            JSONArray  series  = jo.getJSONArray("series");
            JSONArray  time    = jo.getJSONArray("time");
            JSONObject station = jo.getJSONObject("station");
            JSONArray  values  = series.getJSONObject(0).getJSONArray("values");
            
            floodData = new FloodData();
            
            floodData.setName(station.getString("station_id"));
            floodData.setTime(time.getString( time.length()-1));
            floodData.setValue(values.getDouble(values.length()-1));
            floodData.setLon(station.getDouble("lng"));
            floodData.setLat(station.getDouble("lat"));
            
            System.out.println("name: "+station.getString("station_id"));
            System.out.println("time: "+time.getString( time.length()-1) );
            System.out.println("value:"+values.getString( values.length()-1) );
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return floodData;
    }
    
}
