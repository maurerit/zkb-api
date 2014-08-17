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
package net.maurerit.zkb.test;

import java.io.IOException;
import java.util.List;
import net.maurerit.zkb.data.Kill;
import net.maurerit.zkb.util.MockApi;
import net.maurerit.zkb.util.TestBase;
import net.maurerit.zkb.zKB;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author maurerit
 */
public class zKBTest extends TestBase {
    
    @Test
    public void parseKill39865102 ( ) throws IOException, Exception {
        String resourcePath = "killID/39865102";
        super.setup(resourcePath);
        zKB zkb = new zKB();
        zKB.setUrl(MockApi.URL);
        List<Kill> kills = zkb.killID(39865102).fetch();
        
        assertEquals("Should be one kill", 1, kills.size());
        assertEquals("Should be 2 attakcers", 2, kills.get(0).getAttackers().size());
    }
    
    @Test
    public void parseKill39865102NoAttackers ( ) throws IOException, Exception {
        String resourcePath = "no-attackers/killID/39865102";
        super.setup(resourcePath);
        zKB zkb = new zKB();
        zKB.setUrl(MockApi.URL);
        List<Kill> kills = zkb.killID(39865102).attackers(false).fetch();
        
        Kill kill = kills.get(0);
        
        assertEquals("Attackers should be null", null, kill.getAttackers());
    }
}
