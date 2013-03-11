package com.dsb.codegenerator.templates;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Assert;
import org.junit.Test;

public class WfTransferTest {

	@Test
	public void testCreateWfTradeRule() throws IOException {
		VelocityTestConfig velocityTestConfig = new VelocityTestConfig();

		Velocity.init(velocityTestConfig.classLoaderProperties());

		VelocityContext velocityContext = new VelocityContext();
		String rule = new String("Custom");
		velocityContext.put("rule_name", rule);

		Template template = Velocity.getTemplate(velocityTestConfig
				.templatesDir() + "wfTransferRule.vm");

		StringWriter sw = new StringWriter();
		template.merge(velocityContext, sw);

		String clazz = sw.getBuffer().toString();

		Assert.assertNotNull(template);
		Assert.assertTrue(clazz
				.contains("public class CustomTransferRule implements WfTransferRule"));
	}
}
