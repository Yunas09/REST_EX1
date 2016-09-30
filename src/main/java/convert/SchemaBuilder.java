/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author umita
 */
public class SchemaBuilder {
    public static void main(String[] args) {
        HashMap<String, Object> puproperties = new HashMap<>();
        puproperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        puproperties.put("javax.persistence.sql-load-script-source", "Scripts/Data.sql");
        
        
        Persistence.generateSchema("rest_pu", puproperties);
        Persistence.generateSchema("rest_pu", null);

    }
}
