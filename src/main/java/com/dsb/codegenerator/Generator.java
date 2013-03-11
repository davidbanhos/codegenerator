/**
 * 
 */
package com.dsb.codegenerator;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author david
 * 
 */
public class Generator {

	private static final String GENERATE_CMD = "-generate";

	private static final String LIST_CMD = "-list";

	private static String USAGE_MESSAGE = "Usage:\n" + LIST_CMD
			+ ": List all available templates." + "\n" + GENERATE_CMD
			+ " <tempalteName>: generate de template selected";

	private StringBuffer buffer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buffer = new Generator().process(args);
		System.out.println(buffer);
	}

	public StringBuffer process(String[] args) {
		buffer = new StringBuffer();

		if (validArgs(args)) {
			callCommand(args);
		}

		return new StringBuffer(buffer);
	}

	private void callCommand(String[] args) {
		List<String> arguments = Arrays.asList(args);

		if (arguments.contains(LIST_CMD)) {
			list(args);
		}
	}

	private void list(String[] args) {
		buffer.append("List of templates:");

		URL url = this.getClass().getClassLoader().getResource("templates");
		File templateDir = new File(url.getPath());
		
		FileFilter filter = new FileFilter() {
			public boolean accept(File fileTemplate) {
				return fileTemplate.getName().endsWith(".vm");
			}
		};
		
		for (File file : templateDir.listFiles(filter)) {
			buffer.append(file.getName());
		}
	}

	private boolean validArgs(String[] args) {
		boolean valid = true;

		if (emptyArgs(args)) {
			buffer.append(USAGE_MESSAGE);
			valid = false;
		}

		if (valid) {
			List<String> arguments = Arrays.asList(args);
			boolean containsListCmd = arguments.contains(LIST_CMD);
			boolean containsGenerateCmd = arguments.contains(GENERATE_CMD);

			if ((!containsListCmd && !containsGenerateCmd)
					|| (containsListCmd && containsGenerateCmd)) {
				buffer.append(USAGE_MESSAGE);
				valid = false;
			} 
		}

		return valid;
	}

	private boolean emptyArgs(String[] args) {
		return args == null || args.length == 0;
	}

}
