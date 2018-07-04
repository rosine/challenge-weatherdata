package de.exxcellent.challenge.Parser;

/**
 * A simple parser for csv input.
 * @author Bettina Weller
 *
 */
public class SimpleCSVParser implements Parser {

	// delimiter for parsing
	private String delimiter;
	
	public SimpleCSVParser() {
		// set default delimiter for csv
		delimiter = ",";
	}
	
	@Override
	public String[] parse(String s) {
		String[] parsed = s.split(delimiter);
		return parsed;
	}
	
	public String getDelimiter() {
		return delimiter;
	}
	
	public void setDelimiter(String s) {
		delimiter = s;
	}
}
