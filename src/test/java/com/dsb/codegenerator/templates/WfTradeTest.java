package com.dsb.codegenerator.templates;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WfTradeTest {

	private String clazz;
	private StringWriter sw;
	private Template template;

	@Before
	public void setUp() throws Exception {
		if (clazz == null) {
			VelocityTestConfig velocityTestConfig = new VelocityTestConfig();

			Velocity.init(velocityTestConfig.classLoaderProperties());

			VelocityContext velocityContext = new VelocityContext();
			String rule = new String("Custom");
			velocityContext.put("rule_name", rule);

			template = Velocity.getTemplate(velocityTestConfig.templatesDir()
					+ "wfTradeRule.vm");

			sw = new StringWriter();
			template.merge(velocityContext, sw);
			clazz = sw.getBuffer().toString();
		}

	}

	@Test
	public void testCreateWfTradeRule() throws IOException {
		assertNotNull(template);
		assertTrue(clazz
				.contains("public class CustomTradeRule implements WfTradeRule"));
	}

	@Test
	@Ignore
	public void testUpdateMethodMustReturnTrue() {
		Assert.fail("implement!");
	}

}
