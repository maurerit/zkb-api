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

/**
 *
 * @author maurerit
 */
public class Character {
    private int characterId;
    private String characterName;
    private int corporationId;
    private String corporationName;
    private int allianceId;
    private String allianceName;
    private int factionId;
    private String factionName;
    private Double securityStatus;

    /**
     * @return the characterId
     */
    public int getCharacterId() {
        return characterId;
    }

    /**
     * @param characterId the characterId to set
     */
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    /**
     * @return the characterName
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * @param characterName the characterName to set
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /**
     * @return the corporationId
     */
    public int getCorporationId() {
        return corporationId;
    }

    /**
     * @param corporationId the corporationId to set
     */
    public void setCorporationId(int corporationId) {
        this.corporationId = corporationId;
    }

    /**
     * @return the corporationName
     */
    public String getCorporationName() {
        return corporationName;
    }

    /**
     * @param corporationName the corporationName to set
     */
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    /**
     * @return the allianceId
     */
    public int getAllianceId() {
        return allianceId;
    }

    /**
     * @param allianceId the allianceId to set
     */
    public void setAllianceId(int allianceId) {
        this.allianceId = allianceId;
    }

    /**
     * @return the allianceName
     */
    public String getAllianceName() {
        return allianceName;
    }

    /**
     * @param allianceName the allianceName to set
     */
    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    /**
     * @return the factionId
     */
    public int getFactionId() {
        return factionId;
    }

    /**
     * @param factionId the factionId to set
     */
    public void setFactionId(int factionId) {
        this.factionId = factionId;
    }

    /**
     * @return the factionName
     */
    public String getFactionName() {
        return factionName;
    }

    /**
     * @param factionName the factionName to set
     */
    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    /**
     * @return the securityStatus
     */
    public Double getSecurityStatus() {
        return securityStatus;
    }

    /**
     * @param securityStatus the securityStatus to set
     */
    public void setSecurityStatus(Double securityStatus) {
        this.securityStatus = securityStatus;
    }
}
