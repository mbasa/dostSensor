package org.georepublic.main;

import java.util.ArrayList;

import org.georepublic.json.JsonProc;
import org.georepublic.bean.*;
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

        ArrayList<StreamGauge> fdList = jp.getAsgList();
        ArrayList<StreamGauge> tdList = jp.getTdList();
        ArrayList<WaterGauge>  wgList = jp.getWaterList();
        ArrayList<RainGauge>   rnList = jp.getRainList();
        
        SensorDb db = new SensorDb();
        
        for(int i=0;i<fdList.size();i++) {
            db.insertAsgData(fdList.get(i));
        }
        
        
        for(int i=0;i<tdList.size();i++) {
            db.insertTdData(tdList.get(i));
        }
        
        for(int i=0;i<wgList.size();i++) {
            db.insertAwsData(wgList.get(i));
        }
        
        for(int i=0;i<rnList.size();i++) {
            db.insertArgData(rnList.get(i));
        }
        
        System.out.println("completed inserting sensor data into the database");
    }

}
