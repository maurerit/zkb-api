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
package net.maurerit.zkb;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.maurerit.zkb.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author maurerit
 */
public class KillParser {
    //Kill related constants
    public static final String KILL_ID_KEY = "killID";
    public static final String SOLOR_SYS_KEY = "solarSystemID";
    public static final String KILL_TIME_KEY = "killTime";
    public static final String MOON_ID_KEY = "moonID";
    public static final String VICTIM_KEY = "victim";
    public static final String ATTACKERS_KEY = "attackers";
    public static final String ITEMS_KEY = "items";
    public static final String ZKB_KEY = "zkb";
    
    //zkb node constants
    public static final String TOTAL_VALUE_KEY = "totalValue";
    public static final String POINTS_KEY = "points";
    
    //Player related constants
    public static final String CHAR_ID_KEY = "characterID";
    public static final String CHAR_NAME_KEY = "characterName";
    public static final String CORP_ID_KEY = "corporationID";
    public static final String CORP_NAME_KEY = "corporationName";
    public static final String ALLIANCE_ID_KEY = "allianceID";
    public static final String ALLIANCE_NAME_KEY = "allianceName";
    public static final String FACTION_ID_KEY = "factionID";
    public static final String FACTION_NAME_KEY = "factionName";
    
    //Attacker related constants
    public static final String SEC_STATUS_KEY = "securityStatus";
    public static final String DAMAGE_DONE_KEY = "damageDone";
    public static final String FINAL_BLOW_KEY = "finalBlow";
    public static final String WEAPON_TYPE_KEY = "weaponTypeID";
    
    //Attacker and victim constants
    public static final String SHIP_TYPE_KEY = "shipTypeID";
    
    //Victim related constants
    public static final String DAMAGE_TAKEN_KEY = "damageTaken";
    
    //Item related constants
    public static final String TYPE_ID_KEY = "typeID";
    public static final String FLAG_KEY = "flag";
    public static final String QTY_DROPPED_KEY = "qtyDropped";
    public static final String QTY_DESTROYED_KEY = "qtyDestroyed";
    public static final String SINGLETON_KEY = "singleton";
    
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(KillParser.class);
    
    public List<Kill> parse ( InputStream is, boolean isXml ) throws IOException {
        List<Kill> kills = new ArrayList<Kill>();
        
        ObjectMapper mapper;
        if ( isXml ) {
            mapper = new XmlMapper();
        }
        else {
            mapper = new ObjectMapper();
        }
        
        TreeNode root = mapper.readTree(is);
        
        if ( root instanceof ArrayNode ) {
            ArrayNode rootCasted = (ArrayNode)root;
            for ( int idx = 0; idx < rootCasted.size(); idx++ ) {
                kills.add(parseKill(rootCasted.get(idx)));
            }
        }
        
        return kills;
    }
    
    private Kill parseKill ( TreeNode node ) {
        Kill parsedKill = new Kill();
        
        parsedKill.setKillId(longFromText(node.get(KILL_ID_KEY)));
        parsedKill.setKillTime(dateFromText(node.get(KILL_TIME_KEY)));
        parsedKill.setSolarSystemId(intFromText(node.get(SOLOR_SYS_KEY)));
        parsedKill.setMoonId(intFromText(node.get(MOON_ID_KEY)));
        parsedKill.setVictim(parseVictim(node.get(VICTIM_KEY)));
        parsedKill.setTotalValue(doubleFromText(node.get(ZKB_KEY).get(TOTAL_VALUE_KEY)));
        parsedKill.setPoints(longFromText(node.get(ZKB_KEY).get(POINTS_KEY)));
        
        if ( node.get(ATTACKERS_KEY) != null ) {
            parsedKill.setAttackers(parseAttackers(node.get(ATTACKERS_KEY)));
        }
        
        parsedKill.setVictim(parseVictim(node.get(VICTIM_KEY)));
        
        if ( node.get(ITEMS_KEY) != null ) {
            parsedKill.setItems(parseItems(node.get(ITEMS_KEY)));
        }
        
        return parsedKill;
    }
    
    private List<Attacker> parseAttackers ( TreeNode node ) {
        List<Attacker> attackers = new ArrayList<Attacker>();
        
        if ( node instanceof ArrayNode ) {
            ArrayNode arrayNode = (ArrayNode)node;
            
            for ( int idx = 0; idx < arrayNode.size(); idx++ ) {
                JsonNode attackerNode = arrayNode.get(idx);
                Attacker attacker = new Attacker();
                
                attacker.setCharacterId(intFromText(attackerNode.get(CHAR_ID_KEY)));
                attacker.setCharacterName(attackerNode.get(CHAR_NAME_KEY).asText());
                attacker.setCorporationId(intFromText(attackerNode.get(CORP_ID_KEY)));
                attacker.setCorporationName(attackerNode.get(CORP_NAME_KEY).asText());
                attacker.setAllianceId(intFromText(attackerNode.get(ALLIANCE_ID_KEY)));
                attacker.setAllianceName(attackerNode.get(ALLIANCE_NAME_KEY).asText());
                attacker.setFactionId(intFromText(attackerNode.get(FACTION_ID_KEY)));
                attacker.setFactionName(attackerNode.get(FACTION_NAME_KEY).asText());
                attacker.setSecurityStatus(doubleFromText(attackerNode.get(SEC_STATUS_KEY)));
                attacker.setDamageDone(longFromText(attackerNode.get(DAMAGE_DONE_KEY)));
                attacker.setFinalBlow(booleanFromText(attackerNode.get(FINAL_BLOW_KEY)));
                attacker.setWeaponTypeId(intFromText(attackerNode.get(WEAPON_TYPE_KEY)));
                attacker.setWeaponName(TypeID.getTypeName(intFromText(attackerNode.get(WEAPON_TYPE_KEY))));
                attacker.setShipTypeId(intFromText(attackerNode.get(SHIP_TYPE_KEY)));
                attacker.setShipName(TypeID.getTypeName(intFromText(attackerNode.get(SHIP_TYPE_KEY))));
                
                attackers.add(attacker);
            }
        }
        
        return attackers;
    }
    
    private Victim parseVictim ( TreeNode node ) {
        Victim victim = new Victim();
        
        if ( node instanceof JsonNode ) {
            JsonNode nodeCasted = (JsonNode)node;
            
            victim.setCharacterId(intFromText(nodeCasted.get(CHAR_ID_KEY)));
            victim.setCharacterName(nodeCasted.get(CHAR_NAME_KEY).asText());
            victim.setCorporationId(intFromText(nodeCasted.get(CORP_ID_KEY)));
            victim.setCorporationName(nodeCasted.get(CORP_NAME_KEY).asText());
            victim.setAllianceId(intFromText(nodeCasted.get(ALLIANCE_ID_KEY)));
            victim.setAllianceName(nodeCasted.get(ALLIANCE_NAME_KEY).asText());
            victim.setFactionId(intFromText(nodeCasted.get(FACTION_ID_KEY)));
            victim.setFactionName(nodeCasted.get(FACTION_NAME_KEY).asText());
            victim.setShipTypeId(intFromText(nodeCasted.get(SHIP_TYPE_KEY)));
            victim.setShipName(TypeID.getTypeName(intFromText(nodeCasted.get(SHIP_TYPE_KEY))));
            victim.setDamageTaken(intFromText(nodeCasted.get(DAMAGE_TAKEN_KEY)));
        }
        
        return victim;
    }
    
    private List<Item> parseItems ( TreeNode node ) {
        List<Item> items = new ArrayList<Item>();
        
        if ( node instanceof ArrayNode ) {
            ArrayNode arrayNode = (ArrayNode)node;
            
            for ( int idx = 0; idx < arrayNode.size(); idx++ ) {
                JsonNode nodeCasted = (JsonNode)arrayNode.get(idx);
                Item item = new Item();

                item.setTypeId(intFromText(nodeCasted.get(TYPE_ID_KEY)));
                item.setTypeName(TypeID.getTypeName(intFromText(nodeCasted.get(TYPE_ID_KEY))));
                item.setFlag(intFromText(nodeCasted.get(FLAG_KEY)));
                item.setQtyDropped(intFromText(nodeCasted.get(QTY_DROPPED_KEY)));
                item.setQtyDestroyed(intFromText(nodeCasted.get(QTY_DESTROYED_KEY)));

                items.add(item);
            }
        }
        
        return items;
    }
    
    private long longFromText ( TreeNode node ) {
        return ((ValueNode)node).asLong();
    }
    
    private int intFromText ( TreeNode node ) {
        return ((ValueNode)node).asInt();
    }
    
    private double doubleFromText ( TreeNode node ) {
        return ((ValueNode)node).asDouble();
    }
    
    private boolean booleanFromText ( TreeNode node ) {
        return ((ValueNode)node).asBoolean();
    }
    
    private Date dateFromText ( TreeNode node ) {
        String value = ((ValueNode)node).textValue();
        
        Date date;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException ex) {
            logger.error("Could not parse date.", ex);
            date = null;
        }
        
        return date;
    }
}
