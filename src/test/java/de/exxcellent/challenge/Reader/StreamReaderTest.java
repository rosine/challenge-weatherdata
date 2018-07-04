package de.exxcellent.challenge.Reader;

import java.io.InputStream;

//junit imports
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.exxcellent.challenge.Reader.StreamReader;

/**
 * A test class for StreamReader.
 * @author Bettina Weller
 *
 */
public class StreamReaderTest {

	private StreamReader reader;
	private String filePath;
	private String filePath2;
	
	/**
	 * Set up before tests.
	 */
	@Before
	public void setUp() {
		reader = new StreamReader();
		System.out.println("Set up completed");
	}
	
	/**
	 * Tear down after tests.
	 */
	@After
	public void tearDown() {
		reader = null;
		setFilePath("");
		setFilePath2("");
		System.out.println("Tear down completed");
	}
	
	/**
	 * Open and close an existing file without throwing exceptions.
	 */
	@Test
	public void openAndClose() {
		setFilePath("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
		InputStream stream = reader.openStream(filePath);
		
		assertNotEquals(stream, null);
		
		boolean closed = reader.closeStream(stream);
		
		assertTrue(closed);
	}
	
	/**
	 * Open not existing file.
	 */
	@Test
	public void openNotExistingFile() {
		setFilePath("");
		InputStream stream = reader.openStream(filePath);
		
		assertEquals(stream, null);
	}
	
	/**
	 * Close not existing stream.
	 */
	@Test
	public void closeNotExistingStream() {
		InputStream stream = null;
		boolean closed = reader.closeStream(stream);
		
		assertTrue(closed);
	}

	/**
	 * Open two different streams and close them.
	 */
	@Test
	public void openAndCloseMultipleStreams() {
		setFilePath("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
		InputStream stream = reader.openStream(filePath);
		setFilePath2("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");
		InputStream stream2 = reader.openStream(filePath2);
		
		assertNotEquals(stream, null);
		assertNotEquals(stream2, null);
		
		boolean closed = reader.closeStream(stream);
		boolean closed2 = reader.closeStream(stream2);
		assertTrue(closed);
		assertTrue(closed2);
	}
	
	public void setFilePath(String s) {
		filePath = s;
	}

	public void setFilePath2(String s) {
		filePath2 = s;
	}
}
