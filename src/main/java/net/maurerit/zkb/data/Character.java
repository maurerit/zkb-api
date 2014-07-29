/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

/**
 *
 * @author mm66053
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
    private double securityStatus;

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
    public double getSecurityStatus() {
        return securityStatus;
    }

    /**
     * @param securityStatus the securityStatus to set
     */
    public void setSecurityStatus(double securityStatus) {
        this.securityStatus = securityStatus;
    }
}
