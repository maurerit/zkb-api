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
