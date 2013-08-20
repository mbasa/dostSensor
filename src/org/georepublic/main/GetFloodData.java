package org.georepublic.main;

import org.georepublic.json.JsonProc;
import org.georepublic.bean.FloodData;
import org.georepublic.db.FloodDb;

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
        
        JsonProc  jp = new JsonProc( args[0] );
        FloodData fd = jp.getJsonData();
        FloodDb   db = new FloodDb();
        
        db.insertFloodData(fd);
        
    }

}
