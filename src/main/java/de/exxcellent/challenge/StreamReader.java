package de.exxcellent.challenge;

// java imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A simple reader which opens and closes streams.
 * @author Bettina Weller
 * 
 */
public class StreamReader implements Reader {

	public StreamReader() {
		
	}
	
	@Override
	public FileInputStream openStream(String path) {
		File file = new File(path);
		FileInputStream stream = null;
		if(file.exists()) {
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return stream;
	}

	/**
	 * Closes given stream.
	 * Returns true if stream was successfully closed or given stream had the value null.
	 * @param stream: to be closed stream
	 * @return True if stream was closed or is null, else false.
	 */
	@Override
	public boolean closeStream(InputStream stream) {
		if (stream != null) {
			try {
				stream.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			} 
			return false;
		}
		return true;
	}

}
