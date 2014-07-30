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
