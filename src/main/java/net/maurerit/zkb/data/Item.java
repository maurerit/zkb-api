/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.data;

/**
 *
 * @author mm66053
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
