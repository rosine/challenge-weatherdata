package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * An interface for parsers.
 * @author Bettina Weller
 *
 */
public interface Parser {

	/**
	 * Parses fiven string.
	 * @param s to be parsed string
	 * @return String[] of parsed String
	 */
	public String[] parse(String s);
}
