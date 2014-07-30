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
public class Item {
    private int typeId;
    private String typeName;
    private int flag;
    private int qtyDropped;
    private int qtyDestroyed;

    /**
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * @return the qtyDropped
     */
    public int getQtyDropped() {
        return qtyDropped;
    }

    /**
     * @param qtyDropped the qtyDropped to set
     */
    public void setQtyDropped(int qtyDropped) {
        this.qtyDropped = qtyDropped;
    }

    /**
     * @return the qtyDestroyed
     */
    public int getQtyDestroyed() {
        return qtyDestroyed;
    }

    /**
     * @param qtyDestroyed the qtyDestroyed to set
     */
    public void setQtyDestroyed(int qtyDestroyed) {
        this.qtyDestroyed = qtyDestroyed;
    }
}
