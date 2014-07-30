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

import java.util.Date;
import java.util.List;

/**
 *
 * @author maurerit
 */
public class Kill {
    private double totalValue;
    private long points;
    
    private long killId;
    private int solarSystemId;
    private Date killTime;
    private int moonId;
    private List<Attacker> attackers;
    private Victim victim;
    private List<Item> items;

    /**
     * @return the totalValue
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * @return the points
     */
    public long getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(long points) {
        this.points = points;
    }
    
    /**
     * @return the killId
     */
    public long getKillId() {
        return killId;
    }

    /**
     * @param killId the killId to set
     */
    public void setKillId(long killId) {
        this.killId = killId;
    }

    /**
     * @return the solarSystemId
     */
    public int getSolarSystemId() {
        return solarSystemId;
    }

    /**
     * @param solarSystemId the solarSystemId to set
     */
    public void setSolarSystemId(int solarSystemId) {
        this.solarSystemId = solarSystemId;
    }

    /**
     * @return the killTime
     */
    public Date getKillTime() {
        return killTime;
    }

    /**
     * @param killTime the killTime to set
     */
    public void setKillTime(Date killTime) {
        this.killTime = killTime;
    }

    /**
     * @return the moonId
     */
    public int getMoonId() {
        return moonId;
    }

    /**
     * @param moonId the moonId to set
     */
    public void setMoonId(int moonId) {
        this.moonId = moonId;
    }

    /**
     * @return the attackers
     */
    public List<Attacker> getAttackers() {
        return attackers;
    }

    /**
     * @param attackers the attackers to set
     */
    public void setAttackers(List<Attacker> attackers) {
        this.attackers = attackers;
    }

    /**
     * @return the victim
     */
    public Victim getVictim() {
        return victim;
    }

    /**
     * @param victim the victim to set
     */
    public void setVictim(Victim victim) {
        this.victim = victim;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
