package de.exxcellent.challenge.Reader;

import java.io.InputStream;
/**
 * An interface for reader classes.
 * @author Bettina Weller
 *
 */
public interface Reader {

	/**
	 * Open a stream to the given path.
	 * @param path to be opened path
	 * @return stream to given path or null if this is not possible
	 */
	public InputStream openStream(String path);
	
	/**
	 * 
	 * @param stream to be closed stream
	 * @return true for successfully closing the given string else false
	 */
	public boolean closeStream(InputStream stream);
	
}
