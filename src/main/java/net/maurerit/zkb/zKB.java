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
    
    //Limit Modifiers
    public static final String LIMIT_MODIFIER = "limit/";
    public static final String PAGE_MODIFIER = "page/";
    public static final String ST_MODIFIER = "startTime/";
    public static final String ET_MODIFIER = "endTime/";
    public static final String YEAR_MODIFIER = "year/";
    public static final String MONTH_MODIFIER = "month/";
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
    
    private KillParser parser = new KillParser();
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
    private Integer characterID;
    private Integer corporationID;
    private Integer allianceID;
    private Integer factionID;
    private Integer shipTypeID;
    private Integer groupID;
    private Integer solarSystemID;
    private boolean noItems = false;
    private boolean noAttackers = false;
    private boolean apiOnly = false;
    
    public zKB limit(int limit) {
        return this;
    }
    
    public zKB page(int page) {
        return this;
    }
    
    public zKB startTime ( Date date ) {
        return this;
    }
    
    public zKB endTime ( Date date ) {
        return this;
    }
    
    public zKB year ( int year ) {
        return this;
    }
    
    public zKB month ( int month ) {
        return this;
    }
    
    public zKB week ( int week ) {
        return this;
    }
    
    public zKB beforeKillID ( int killID ) {
        return this;
    }
    
    public zKB afterKillID ( int killID ) {
        return this;
    }
    
    public zKB pastSeconds ( int pastSeconds ) {
        return this;
    }
    
    public zKB killID ( int killID ) {
        return this;
    }
    
    public zKB kills ( ) {
        if ( killsOnly ) {
            killsOnly = false;
        }
        else {
            killsOnly = true;
        }
        
        return this;
    }
    
    public zKB losses ( ) {
        if ( lossesOnly ) {
            lossesOnly = false;
        }
        else {
            lossesOnly = true;
        }
        
        return this;
    }
    
    public zKB wSpace ( ) {
        if ( wSpaceOnly ) {
            wSpaceOnly = false;
        }
        else {
            wSpaceOnly = true;
        }
        
        return this;
    }
    
    public zKB solo ( ) {
        if ( soloOnly ) {
            soloOnly = false;
        }
        else {
            soloOnly = true;
        }
        
        return this;
    }
    
    public List<Kill> fetch ( ) {
        return null;
    }
    
    private String buildUrl ( ) {
        return ROOT_URL;
    }
}
