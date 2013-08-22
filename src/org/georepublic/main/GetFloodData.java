package org.georepublic.main;

import java.util.ArrayList;

import org.georepublic.json.JsonProc;
import org.georepublic.bean.FloodData;
import org.georepublic.db.SensorDb;

public class GetFloodData {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        if( args.length != 1 ) {
            System.out.println("Usage: GetFloodData <DOST URL>");
            System.exit(0);
        }
        
        JsonProc jp = new JsonProc( args[0] );
        jp.getJsonData();

        ArrayList<FloodData> fdList = jp.getFloodDataList();
        SensorDb db = new SensorDb();
        
        for(int i=0;i<fdList.size();i++) {
            db.insertFloodData(fdList.get(i));
        }
        
        System.out.println("completed inserting sensor data into the database");
    }

}
