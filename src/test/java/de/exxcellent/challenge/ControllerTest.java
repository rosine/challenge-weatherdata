package de.exxcellent.challenge;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;

//junit imports
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for Controller.
 * @author Bettina Weller
 *
 */
public class ControllerTest {

	private Controller controller;
	private String path;
	
	/**
	 * Set up before tests.
	 */
	@Before
	public void setUp() {
		controller = new Controller();
		System.out.println("Set up completed");
	}
	
	/**
	 * Tear down after tests.
	 */
	@After
	public void tearDown() {
		controller = null;
		System.out.println("Tear down completed");
	}
	
	/**
	 * Get smallest spread in weather.csv
	 * Result is day 14.
	 */
	@Test
	public void getSmallestSpread() {
		setPath("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		controller.getSmallestSpread(path);
		System.out.println(out);
		assertTrue((out.toString()).contains("14"));
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		assertFalse(controller.getStreamIsOpen());
	}
	
	/**
	 * Get smallest spread from not existing file. No stream should be opened.
	 */
	@Test
	public void getSmallestSpreadFromNotExistingFile() {
		setPath("");
		controller.getSmallestSpread(path);
		
		assertFalse(controller.getStreamIsOpen());
	}


	private void setPath(String path) {
		this.path = path;
	}
}
