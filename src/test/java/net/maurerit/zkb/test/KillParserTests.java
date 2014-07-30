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
package net.maurerit.zkb.test;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import net.maurerit.zkb.KillParser;
import net.maurerit.zkb.data.Kill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author maurerit
 */
public class KillParserTests {
    
    public static KillParser killParser = new KillParser();
    
    @Test
    public void parseKill39865102FromXML ( ) throws IOException {
//        URL url = new URL("https://zkillboard.com/api/killID/39865102/xml/");
//        List<Kill> kill = KillParser.parse(uc.getInputStream(), true);
    }
    
    @Test
    public void parseKill39865102FromJSON ( ) throws IOException {
        URL url = new URL("https://zkillboard.com/api/killID/39865102/");
        List<Kill> kills = killParser.parse(url.openStream(), false);
    }
    
    @Test
    public void parseKill39865102FromJSONNoAttackers ( ) throws IOException {
        URL url = new URL("https://zkillboard.com/api/no-attackers/killID/39865102/");
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        Kill kill = kills.get(0);
        
        assertEquals("Attackers should be null", null, kill.getAttackers());
    }
    
    @Test
    public void parseKill39865102FromJSONNoItems ( ) throws IOException {
        URL url = new URL("https://zkillboard.com/api/no-items/killID/39865102/");
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        Kill kill = kills.get(0);
        
        assertEquals("Items should be null", null, kill.getItems());
    }
    
    @Test
    public void getMarqAideronsKills ( ) throws IOException {
        URL url = new URL("https://zkillboard.com/api/characterID/93461829/page/2");
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        System.out.println(kills.size());
    }
}
