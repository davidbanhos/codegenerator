package com.dsb.codegenerator.templates;

import static org.junit.Assert.assertNotNull;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VelocitySetupTest {

	private Velocity velocity;
	private VelocityTestConfig velocityTestConfig;

	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		if (velocity == null) {
			velocityTestConfig = new VelocityTestConfig();
			velocity = new Velocity();
			velocity.init(velocityTestConfig.classLoaderProperties());
		}
	}

	@SuppressWarnings("static-access")
	@Test
	public void testVelocityTemplateExecution() {
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("foo", "Vulcan");
		Template template = velocity.getTemplate(velocityTestConfig
				.templatesDir() + "simpleTemplate.vm");

		assertNotNull(template);

		StringWriter writer = new StringWriter();
		template.merge(velocityContext, writer);

		String generated = writer.getBuffer().toString();

		String expected = "Hello Vulcan World!";
		Assert.assertEquals(expected, generated);
	}

}
