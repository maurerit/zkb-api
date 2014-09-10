package net.maurerit.zkb.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Candle
 */
public class ExchangeProcessor implements Processor {
	String fullPath;

	public ExchangeProcessor(String fullPath) {
		this.fullPath = fullPath;
	}

	public void process(Exchange exchange) {
//            try {
//                String output = MockApi.response(fullPath);
//                ByteArrayOutputStream os = new ByteArrayOutputStream();
//                GZIPOutputStream gos = new GZIPOutputStream(os);
//                gos.write(output.getBytes("UTF-8"));
//                gos.close();
//                exchange.getOut().setBody(os.toByteArray());
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
            exchange.getOut().setBody(MockApi.response(fullPath));
	}
}