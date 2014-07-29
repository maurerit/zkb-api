/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.maurerit.zkp.test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import net.maurerit.zkb.KillParser;
import net.maurerit.zkb.data.Kill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author mm66053
 */
public class KillParserTests {
    
    public static KillParser killParser = new KillParser();
    
    @Test
    public void parseKill39865102FromXML ( ) throws IOException {
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
//        URL url = new URL("https://zkillboard.com/api/killID/39865102/xml/");
//        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
//        uc.connect();
//        List<Kill> kill = KillParser.parse(uc.getInputStream(), true);
//        uc.disconnect();
    }
    
    @Test
    public void parseKill39865102FromJSON ( ) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
        URL url = new URL("https://zkillboard.com/api/killID/39865102/");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
        List<Kill> kills = killParser.parse(uc.getInputStream(), false);
        uc.disconnect();
    }
    
    @Test
    public void parseKill39865102FromJSONNoAttackers ( ) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
        URL url = new URL("https://zkillboard.com/api/no-attackers/killID/39865102/");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
        List<Kill> kills = killParser.parse(uc.getInputStream(), false);
        uc.disconnect();
        
        Kill kill = kills.get(0);
        
        assertEquals("Attackers should be null", null, kill.getAttackers());
    }
    
    @Test
    public void parseKill39865102FromJSONNoItems ( ) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
        URL url = new URL("https://zkillboard.com/api/no-items/killID/39865102/");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
        List<Kill> kills = killParser.parse(uc.getInputStream(), false);
        uc.disconnect();
        
        Kill kill = kills.get(0);
        
        assertEquals("Items should be null", null, kill.getItems());
    }
    
    @Test
    public void getMarqAideronsKills ( ) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cdcproxy.kroger.com",3128));
        URL url = new URL("https://zkillboard.com/api/characterID/93461829/page/2");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
        List<Kill> kills = killParser.parse(uc.getInputStream(), false);
        uc.disconnect();
        
        System.out.println(kills.size());
    }
}
