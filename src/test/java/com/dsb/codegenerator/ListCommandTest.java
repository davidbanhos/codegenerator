package com.dsb.codegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ListCommandTest {

	private static final String LIST_OF_TEMPLATES = "List of templates:";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	private Generator generator;

	@Before
	public void setUp() throws Exception {
		generator = new Generator();
	}

	@Test
	public void testArgumentMustCallFunctionality() {
		String[] args = new String[] { "-list" };
		StringBuffer buffer = generator.process(args);
		assertTrue(buffer.toString().contains(LIST_OF_TEMPLATES));
	}

	@Test
	public void testExtraArgumentsMustBeIgnored() {
		String[] args = new String[] { "-list" , "xxxxx", "bbbb"};
		StringBuffer buffer = generator.process(args);
		assertTrue(buffer.toString().contains(LIST_OF_TEMPLATES));
	}
	
	
	@Test
	public void testListMustShowAvailableTemplates() {
		String[] args = new String[] { "-list" };
		StringBuffer buffer = generator.process(args);
		String output = buffer.toString();
		assertTrue(output.contains(LIST_OF_TEMPLATES));
		assertTrue(output.contains("simpleTemplate.vm"));
	}

}
