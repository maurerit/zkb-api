/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

/**
 *
 * @author mm66053
 */
public class Attacker extends Combatant {
    private long damageDone;
    private boolean finalBlow;
    private int weaponTypeId;
    private String weaponName;

    /**
     * @return the damageDone
     */
    public long getDamageDone() {
        return damageDone;
    }

    /**
     * @param damageDone the damageDone to set
     */
    public void setDamageDone(long damageDone) {
        this.damageDone = damageDone;
    }

    /**
     * @return the finalBlow
     */
    public boolean isFinalBlow() {
        return finalBlow;
    }

    /**
     * @param finalBlow the finalBlow to set
     */
    public void setFinalBlow(boolean finalBlow) {
        this.finalBlow = finalBlow;
    }

    /**
     * @return the weaponTypeId
     */
    public int getWeaponTypeId() {
        return weaponTypeId;
    }

    /**
     * @param weaponTypeId the weaponTypeId to set
     */
    public void setWeaponTypeId(int weaponTypeId) {
        this.weaponTypeId = weaponTypeId;
    }

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * @param weaponName the weaponName to set
     */
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
