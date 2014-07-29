/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

import java.util.List;

/**
 *
 * @author mm66053
 */
public class Victim extends Combatant {
    private int damageTaken;

    /**
     * @return the damageTaken
     */
    public int getDamageTaken() {
        return damageTaken;
    }

    /**
     * @param damageTaken the damageTaken to set
     */
    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }
}
