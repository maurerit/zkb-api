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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.maurerit.zkb.data.Kill;

/**
 *
 * @author maurerit
 */
public class zKB {
    public static final String ROOT_URL = "https://zkillboard.com/api/";
    
    public static final String DELIMITER = "/";
    
    //Limit Modifiers
    public static final String LIMIT_MODIFIER = "limit/";
    public static final String PAGE_MODIFIER = "page/";
    public static final String ST_MODIFIER = "startTime/";
    public static final String ET_MODIFIER = "endTime/";
    public static final String YEAR_MODIFIER = "year/";
    public static final String MONTH_MODIFIER = "month/";
    public static final String WEEK_MODIFIER = "week/";
    public static final String BKID_MODIFIER = "beforeKillID/";
    public static final String AKID_MODIFIER = "afterKillID/";
    public static final String PS_MODIFIER = "pastSeconds/";
    public static final String KILL_ID_MODIFIER = "killID/";
    
    //Fetch Type Modifiers
    public static final String KILLS_MODIFIER = "kills/";
    public static final String LOSSES_MODIFIER = "losses/";
    public static final String W_SPACE_MODIFIER = "w-space/";
    public static final String SOLO_MODIFIER = "solo/";
    
    //Order Modifiers
    public static final String ORDER_MODIFIER = "orderDirection/";
    public static final String ORDER_DESC_STR = "desc";
    
    //Fetch Modifiers
    public static final String CHAR_ID_MODIFIER = "characterID/";
    public static final String CORP_ID_MODIFIER = "corporationID/";
    public static final String ALLIANCE_ID_MODIFIER = "allianceID/";
    public static final String FACTION_ID_MODIFIER = "factionID/";
    public static final String SHIP_TYPE_ID_MODIFIER = "shipTypeID/";
    public static final String GROUP_ID_MODIFIER = "groupID/";
    public static final String SOLOR_SYS_ID_MODIFIER = "solarSystemID/";
    
    //Information Modifiers
    public static final String NO_ITEMS_MODIFIER = "no-items/";
    public static final String NO_ATTACKERS_MODIFIER = "no-attackers/";
    public static final String API_ONLY_MODIFER = "api-only/";
    
    //API Documented constants
    public static final Integer RESULT_SET_LIMIT = 200;
    public static final Integer PAST_SECONDS_LIMIT = 604800;
    public static final Integer ID_COUNT_LIMIT = 10;
    public static final Integer PAGE_REQUEST_MAX = 10;
    public static final DateFormat format = new SimpleDateFormat("YYYYMMddHHmm");
    
    private static String url;
    
    private KillParser parser = new KillParser();
    private Proxy proxy;
    private HttpURLConnection uc;
    private Integer limit;
    private Integer page;
    private String startTime;
    private String endTime;
    private String year;
    private String month;
    private String week;
    private Long beforeKillID;
    private Long afterKillID;
    private Integer pastSeconds;
    private Long killID;
    private boolean killsOnly = false;
    private boolean lossesOnly = false;
    private boolean wSpaceOnly = false;
    private boolean soloOnly = false;
    private boolean orderAscending = true;
    private Long characterID;
    private Long corporationID;
    private Long allianceID;
    private Long factionID;
    private Long shipTypeID;
    private Long groupID;
    private Long solarSystemID;
    private boolean noItems = false;
    private boolean noAttackers = false;
    private boolean apiOnly = false;
    
    public zKB ( ) {
        url = ROOT_URL;
    }
    
    public static void setUrl ( String url ) {
        zKB.url = url;
    }
    
    public zKB proxy ( Proxy proxy ) {
        this.proxy = proxy;
        return this;
    }
    
    public zKB limit(int limit) {
        //TODO: Add validation against RESULT_SET_LIMIT
        this.limit = limit;
        return this;
    }
    
    public zKB page(int page) {
        //TODO: Add validation against PAGE_REQUEST_MAX
        this.page = page;
        return this;
    }
    
    public zKB startTime ( Date date ) {
        this.startTime = format.format(date);
        return this;
    }
    
    public zKB endTime ( Date date ) {
        this.endTime = format.format(date);
        return this;
    }
    
    public zKB year ( int year ) {
        //TODO: Add in sane validation... EVE didn't exist before 2003 :P
        this.year = Integer.toString(year);
        return this;
    }
    
    public zKB month ( int month ) {
        this.month = Integer.toString(month);
        return this;
    }
    
    public zKB week ( int week ) {
        this.week = Integer.toString(week);
        return this;
    }
    
    public zKB beforeKillID ( long killID ) {
        this.beforeKillID = killID;
        return this;
    }
    
    public zKB afterKillID ( long killID ) {
        this.afterKillID = killID;
        return this;
    }
    
    public zKB pastSeconds ( int pastSeconds ) {
        this.pastSeconds = pastSeconds;
        return this;
    }
    
    public zKB killID ( long killID ) {
        this.killID = killID;
        return this;
    }
    
    public zKB kills ( boolean value ) {
        killsOnly = value;
        return this;
    }
    
    public zKB losses ( boolean value ) {
        lossesOnly = value;
        return this;
    }
    
    public zKB wSpace ( boolean value ) {
        wSpaceOnly = value;
        return this;
    }
    
    public zKB solo ( boolean value ) {
        soloOnly = value;
        return this;
    }
    
    public zKB orderAscending ( boolean value ) {
        orderAscending = value;
        return this;
    }
    
    public zKB characterID ( long characterID ) {
        this.characterID = characterID;
        return this;
    }
    
    public zKB allianceID ( long allianceID ) {
        this.allianceID = allianceID;
        return this;
    }
    
    public zKB factionID ( long factionID ) {
        this.factionID = factionID;
        return this;
    }
    
    public zKB shipTypeID ( long shipTypeID ) {
        this.shipTypeID = shipTypeID;
        return this;
    }
    
    public zKB groupID ( long groupID ) {
        this.groupID = groupID;
        return this;
    }
    
    public zKB solarSystemID ( long solarSystemID ) {
        this.solarSystemID = solarSystemID;
        return this;
    }
    
    public zKB items ( boolean value ) {
        noItems = !value;
        return this;
    }
    
    public zKB attackers ( boolean value ) {
        noAttackers = !value;
        return this;
    }
    
    public zKB apiOnly ( boolean value ) {
        apiOnly = value;
        return this;
    }
    
    public List<Kill> fetch ( ) throws MalformedURLException, IOException {
        String fetchUrlString = buildUrl();
        URL fetchUrl = new URL(fetchUrlString);
        
        InputStream stream = openStream(fetchUrl);
        
        List<Kill> kills = parser.parse(stream, false);
        
        if ( uc != null ) {
            uc.disconnect();
            uc = null;
        }
        
        return kills;
    }
    
    private String buildUrl ( ) {
        StringBuilder fetchString = new StringBuilder();
        
        fetchString.append(url);
        
        if ( !url.endsWith(DELIMITER) ) {
            fetchString.append(DELIMITER);
        }
        
        if ( noItems ) {
            fetchString.append(NO_ITEMS_MODIFIER);
        }
        
        if ( noAttackers ) {
            fetchString.append(NO_ATTACKERS_MODIFIER);
        }
        
        if ( apiOnly ) {
            fetchString.append(API_ONLY_MODIFER);
        }
        
        if ( limit != null ) {
            fetchString.append(LIMIT_MODIFIER)
                       .append(limit)
                       .append(DELIMITER);
        }
        
        if ( page != null && limit == null ) {
            fetchString.append(PAGE_MODIFIER)
                       .append(page)
                       .append(DELIMITER);
        }
        
        if ( startTime != null ) {
            fetchString.append(ST_MODIFIER)
                       .append(startTime)
                       .append(DELIMITER);
        }
        
        if ( endTime != null ) {
            fetchString.append(ET_MODIFIER)
                       .append(endTime)
                       .append(DELIMITER);
        }
        
        if ( year != null ) {
            fetchString.append(YEAR_MODIFIER)
                       .append(year)
                       .append(DELIMITER);
        }
        
        if ( month != null && year != null ) {
            fetchString.append(MONTH_MODIFIER)
                       .append(month)
                       .append(DELIMITER);
        }
        
        if ( week != null && year != null ) {
            fetchString.append(WEEK_MODIFIER)
                       .append(week)
                       .append(DELIMITER);
        }
        
        if ( beforeKillID != null ) {
            fetchString.append(BKID_MODIFIER)
                       .append(beforeKillID)
                       .append(DELIMITER);
        }
        
        if ( afterKillID != null ) {
            fetchString.append(AKID_MODIFIER)
                       .append(afterKillID)
                       .append(DELIMITER);
        }
        
        if ( pastSeconds != null && pastSeconds <= PAST_SECONDS_LIMIT ) {
            fetchString.append(PAST_SECONDS_LIMIT)
                       .append(pastSeconds)
                       .append(DELIMITER);
        }
        
        if ( killID != null ) {
            fetchString.append(KILL_ID_MODIFIER)
                       .append(killID)
                       .append(DELIMITER);
        }
        
        if ( killsOnly ) {
            fetchString.append(KILLS_MODIFIER);
        }
        
        if ( lossesOnly && !killsOnly ) {
            fetchString.append(LOSSES_MODIFIER);
        }
        
        if ( wSpaceOnly ) {
            fetchString.append(W_SPACE_MODIFIER);
        }
        
        if ( soloOnly ) {
            fetchString.append(SOLO_MODIFIER);
        }
        
        if ( !orderAscending ) {
            fetchString.append(ORDER_MODIFIER)
                       .append(ORDER_DESC_STR)
                       .append(DELIMITER);
        }
        
        if ( characterID != null ) {
            fetchString.append(CHAR_ID_MODIFIER)
                       .append(characterID)
                       .append(DELIMITER);
        }
        
        if ( corporationID != null ) {
            fetchString.append(CORP_ID_MODIFIER)
                       .append(corporationID)
                       .append(DELIMITER);
        }
        
        if ( allianceID != null ) {
            fetchString.append(ALLIANCE_ID_MODIFIER)
                       .append(allianceID)
                       .append(DELIMITER);
        }
        
        if ( factionID != null ) {
            fetchString.append(FACTION_ID_MODIFIER)
                       .append(factionID)
                       .append(DELIMITER);
        }
        
        if ( shipTypeID != null ) {
            fetchString.append(SHIP_TYPE_ID_MODIFIER)
                       .append(shipTypeID)
                       .append(DELIMITER);
        }
        
        if ( groupID != null ) {
            fetchString.append(GROUP_ID_MODIFIER)
                       .append(groupID)
                       .append(DELIMITER);
        }
        
        if ( solarSystemID != null ) {
            fetchString.append(SOLOR_SYS_ID_MODIFIER)
                       .append(solarSystemID)
                       .append(DELIMITER);
        }
        
        return fetchString.toString();
    }
    
    private InputStream openStream ( URL url ) throws IOException {
        InputStream stream;
        
        if ( proxy != null ) {
            uc = (HttpURLConnection)url.openConnection(proxy);
            uc.connect();
            stream = uc.getInputStream();
        }
        else {
            stream = url.openStream();
        }
        
        return stream;
    }
}
