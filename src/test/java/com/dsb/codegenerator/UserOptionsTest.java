package com.dsb.codegenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserOptionsTest {

	public static String expectedUsage = "Usage:\n-list: List all available templates." +
			"\n-generate <tempalteName>: generate de template selected";
	private Generator generator;;

	@Before
	public void setUp() throws Exception {
		generator = new Generator();
	}

	@Test
	public void testParamsNullShowUsage() {
		String[] args = null;
		StringBuffer buffer = generator.process(args);
		assertEquals(expectedUsage, buffer.toString());
	}
	
	@Test
	public void testParamsEmptyShowUsage() {
		String[] args = new String[]{};
		StringBuffer buffer = generator.process(args);
		assertEquals(expectedUsage, buffer.toString());
	}
	
	@Test
	public void testParamsEmptyValuesShowUsage() {
		String[] args = new String[]{" ", " ", " "};
		StringBuffer buffer = generator.process(args);
		assertEquals(expectedUsage, buffer.toString());
	}
	
	@Test 
	public void testInvalidArgsMustShowUsage() {
		String[] args = "xcxxxc cczx".split(" ");
		StringBuffer buffer = generator.process(args);
		assertEquals(expectedUsage, buffer.toString());
	}
	
	@Test
	public void testListAndGenerateTogetherMustShowUsage() {
		String[] args = "-list -generate xxxx".split(" ");
		StringBuffer buffer = generator.process(args);
		assertEquals(expectedUsage, buffer.toString());
	}
	
	
}
