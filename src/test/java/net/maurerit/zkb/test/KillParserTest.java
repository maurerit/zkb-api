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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.zip.GZIPInputStream;
import net.maurerit.zkb.KillParser;
import net.maurerit.zkb.data.Attacker;
import net.maurerit.zkb.data.Item;
import net.maurerit.zkb.data.Kill;
import net.maurerit.zkb.data.Victim;
import net.maurerit.zkb.util.MockApi;
import net.maurerit.zkb.util.TestBase;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author maurerit
 */
public class KillParserTest extends TestBase {
    
    public static KillParser killParser = new KillParser();
    private static final DateFormat dateFormat = new SimpleDateFormat("YYYYMMdd HH:mm:ss");
    
//    @Test
    public void parseKill39865102FromXML ( ) {
    }
    
    @Test
    public void parseKill39865102 ( ) throws IOException, Exception {
        String resourcePath = "killID/39865102";
        super.setup(resourcePath);
        URL url = new URL(MockApi.URL + resourcePath + "/");
//        List<Kill> kills = killParser.parse(new GZIPInputStream(url.openStream()), false);
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        Date date = dateFormat.parse("20140703 04:05:00");
        Kill kill = kills.get(0);
        
        assertEquals("Kill id should be: 39865102", 39865102, kill.getKillId());
        assertEquals("Kill solar system id should be: 30045332", 30045332, kill.getSolarSystemId());
        assertEquals("Kill moon should be: 0", 0, kill.getMoonId());
        assertEquals("Kill total value should be: 1402281.82", 1402281.82d, kill.getTotalValue(), 0);
        assertEquals("Kill points should be: 30", 30, kill.getPoints());
        
        Victim victim = kill.getVictim();
        
        assertEquals("Damage taken should be: 3367", 3367, victim.getDamageTaken());
        assertEquals("Ship Type ID should be: 16240 for the victim",16240,victim.getShipTypeId());
        assertEquals("Ship Name should be Catalyst for the victim","Catalyst",victim.getShipName());
        assertEquals("Victims character id should be: 94756803", 94756803, victim.getCharacterId());
        assertEquals("Victims name should be: Verona ROKH", "Verona ROKH", victim.getCharacterName());
        assertEquals("Victims corp id should be: 98319884", 98319884, victim.getCorporationId());
        assertEquals("Victims corp name should be: Sentinels of Chaos", "Sentinels of Chaos", victim.getCorporationName());
        assertEquals("Victims alliance id should be: 0", 0, victim.getAllianceId());
        assertEquals("Victims alliance name should be blank", "", victim.getAllianceName());
        assertEquals("Victims faction id should be: 500001", 500001, victim.getFactionId());
        assertEquals("Victims faction name should be: Caldari State", "Caldari State", victim.getFactionName());
        assertEquals("Victims security status should be null", null, victim.getSecurityStatus());
        
        Attacker attacker = kills.get(0).getAttackers().get(1);
        
        assertEquals("domer's damage should be: 1317", 1317, attacker.getDamageDone());
        assertEquals("domer didn't get the final blow", false, attacker.isFinalBlow());
        assertEquals("domer used Caldari Navy Scourge Light Missile to kill his prey", "Caldari Navy Scourge Light Missile", attacker.getWeaponName());
        assertEquals("domer used weapon type: 27361", 27361, attacker.getWeaponTypeId());
        assertEquals("domers sec status should be: -5.2", -5.2d, attacker.getSecurityStatus().doubleValue(), 0);
        
        Item item = kills.get(0).getItems().get(1);
        
        assertEquals("Item 2 should be id: 450", 450, item.getTypeId());
        assertEquals("Item 2 should be name: Gatling Pulse Laser I", "Gatling Pulse Laser I", item.getTypeName());
        assertEquals("Item 2 qty dropped should be: 0", 0, item.getQtyDropped());
        assertEquals("Item 2 qty destroyed should be: 1", 1, item.getQtyDestroyed());
        assertEquals("Item 2 flag should be: 27", 27, item.getFlag());
    }
    
    @Test
    public void parseKill39865102badDate ( ) throws IOException, Exception {
        String resourcePath = "killID/39865102baddate";
        super.setup(resourcePath);
        URL url = new URL(MockApi.URL + resourcePath + "/");
//        List<Kill> kills = killParser.parse(new GZIPInputStream(url.openStream()), false);
        List<Kill> kills = killParser.parse(url.openStream(), false);
        assertEquals("Date should be null",null,kills.get(0).getKillTime());
    }
    
    @Test
    public void parseKill39865102NoAttackers ( ) throws IOException, Exception {
        String resourcePath = "no-attackers/killID/39865102";
        super.setup(resourcePath);
        URL url = new URL(MockApi.URL + resourcePath + "/");
//        List<Kill> kills = killParser.parse(new GZIPInputStream(url.openStream()), false);
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        Kill kill = kills.get(0);
        
        assertEquals("Attackers should be null", null, kill.getAttackers());
    }
    
    @Test
    public void parseKill39865102NoItems ( ) throws IOException, Exception {
        String resourcePath = "no-items/killID/39865102";
        super.setup(resourcePath);
        URL url = new URL(MockApi.URL + resourcePath + "/");
//        List<Kill> kills = killParser.parse(new GZIPInputStream(url.openStream()), false);
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        Kill kill = kills.get(0);
        
        assertEquals("Items should be null", null, kill.getItems());
    }
    
    @Test
    public void page2OfMarqAideronsKills ( ) throws IOException, Exception {
        String resourcePath = "characterID/93461829/page/2";
        super.setup(resourcePath);
        URL url = new URL(MockApi.URL + resourcePath + "/");
//        List<Kill> kills = killParser.parse(new GZIPInputStream(url.openStream()), false);
        List<Kill> kills = killParser.parse(url.openStream(), false);
        
        assertEquals("Page 2 of kills should be 146", 146, kills.size());
    }
}
