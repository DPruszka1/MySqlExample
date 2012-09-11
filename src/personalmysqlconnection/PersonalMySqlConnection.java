/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personalmysqlconnection;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JokermanBuilt
 */
public class PersonalMySqlConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DBAccessor db;
        
        db = new DB_Generic();
        
        db.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://<address>:3306", "<user>", "<password>");

        String sql = "Select * From sakila.actor";
        
        List<Map> rawData = db.findRecords(sql, true);
        
        for(Map record: rawData){
            System.out.print(record.get("actor_id").toString());
            System.out.print(" " + record.get("first_name").toString());
            System.out.print(" " + record.get("last_name").toString());
            System.out.println(" " + record.get("last_update").toString());
        }

    }
}
