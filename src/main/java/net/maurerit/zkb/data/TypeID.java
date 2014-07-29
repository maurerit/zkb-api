/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mm66053
 */
public class TypeID {
    private static final Map<Integer, String> typeIdMap;
    private static final Pattern pattern = Pattern.compile("(?<id>\\d+)\\t+(?<value>.*)");
    
    static {
        typeIdMap = new HashMap<Integer, String>();
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(TypeID.class.getResourceAsStream("/typeid.txt")));
            
            String line;
            
            while ( (line = reader.readLine()) != null ) {
                Matcher matcher = pattern.matcher(line);
                if ( matcher.matches() ) {
                    Integer id = Integer.parseInt(matcher.group("id"));
                    String value = matcher.group("value");
                    
                    typeIdMap.put(id, value);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TypeID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getTypeName ( Integer key ) {
        return typeIdMap.get(key);
    }
}
