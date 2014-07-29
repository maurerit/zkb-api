/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkp.test;

import net.maurerit.zkb.data.TypeID;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mm66053
 */
public class TypeIDTests {
    
    @Test
    public void findCorpse ( ) {
        String value = TypeID.getTypeName(25);
        assertEquals("Value should be 'Corpse'", "Corpse", value);
    }
}
