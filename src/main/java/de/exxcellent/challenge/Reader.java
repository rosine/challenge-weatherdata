package de.exxcellent.challenge;

import java.io.InputStream;
/**
 * An interface for reader classes.
 * @author Bettina Weller
 *
 */
public interface Reader {

	public InputStream openStream(String path);
	
	public boolean closeStream(InputStream stream);
	
}
