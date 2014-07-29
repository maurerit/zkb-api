/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkb.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import net.maurerit.zkb.data.Kill;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mm66053
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
