package com.dsb.codegenerator.templates;

import java.util.Properties;

public class VelocityTestConfig {

	Properties classLoaderProperties() {
		Properties p = new Properties();
		p.put("resource.loader", "class");
		p.put("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		return p;
	}
	
	String templatesDir() {
		return "templates/";
	}

}
