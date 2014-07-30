package net.maurerit.zkb.util;

import net.maurerit.zkb.zKB;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;

public abstract class TestBase {
	private final CamelContext context = new DefaultCamelContext();

	public void setup( final String resourcePath ) throws Exception {
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
//				from("jetty:" + MockApi.URL + "/" + resourcePath)
//						.process(new ExchangeProcessor(resourcePath + ".json"))
//						.end();
                                from("jetty:" + MockApi.URL + resourcePath + "/")
                                                .process(new ExchangeProcessor("/" + resourcePath + ".json"))
                                                .end();
			}
		});
		context.start();
		zKB.setUrl(MockApi.URL);
	}

	@After
	public void cleanup() throws Exception {
		context.stop();
	}
}