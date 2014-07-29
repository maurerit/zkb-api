/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

/**
 *
 * @author mm66053
 */
public class Combatant extends Character {
    private int shipTypeId;
    private String shipName;

    /**
     * @return the shipTypeId
     */
    public int getShipTypeId() {
        return shipTypeId;
    }

    /**
     * @param shipTypeId the shipTypeId to set
     */
    public void setShipTypeId(int shipTypeId) {
        this.shipTypeId = shipTypeId;
    }

    /**
     * @return the shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * @param shipName the shipName to set
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
}
