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
