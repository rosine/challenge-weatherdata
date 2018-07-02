package de.exxcellent.challenge;

//junit imports
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleCSVParserTest {

	private SimpleCSVParser parser;
	private String parse;
	private String[] compare;
	
	/**
	 * Set up before tests.
	 */
	@Before
	public void setUp() {
		parser = new SimpleCSVParser();
		System.out.println("Set up completed");
	}
	
	/**
	 * Tear down after tests.
	 */
	@After
	public void tearDown() {
		parser = null;
		setParse("");
		System.out.println("Tear down completed");
	}
	
	/**
	 * Parse a csv formatted string.
	 */
	@Test
	public void parse() {
		setParse("a,b,c");
		setCompare(new String[] {"a", "b", "c"});
		String[] parsed = parser.parse(parse);
		
		for(int i = 0; i < parsed.length; i++) {
			assertEquals(parsed[i], compare[i]);
		}
	}

	/**
	 * Parse an empty string.
	 */
	@Test
	public void parseEmpty() {
		setParse("");
		setCompare(new String[] {""});
		String[] parsed = parser.parse(parse);
		
		for(int i = 0; i < parsed.length; i++) {
			assertEquals(parsed[i], compare[i]);
		}
	}
	
	public String getParse() {
		return parse;
	}

	public void setParse(String parse) {
		this.parse = parse;
	}

	public String[] getCompare() {
		return compare;
	}

	public void setCompare(String[] compare) {
		this.compare = compare;
	}

}
