/*
 * Copyright 2014 maurerit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * @author maurerit
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
