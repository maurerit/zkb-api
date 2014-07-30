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
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import org.junit.*;

/**
 *
 * @author maurerit
 */
public class zKBTests {
    
    @Test
    public void parseKill39865102 ( ) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
        URL url = new URL("https://zkillboard.com/api/killID/39865102/");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
//        List<Kill> kills = killParser.parse(uc.getInputStream(), false);
        uc.disconnect();
    }
}
