package net.maurerit.zkb.util;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

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
		exchange.getOut().setBody(MockApi.response(fullPath));
	}
}