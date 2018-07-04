package de.exxcellent.challenge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;

//junit imports
import static org.junit.Assert.*;
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
		controller.setColumn1(0);
		controller.setColumn2(1);
		controller.setColumn3(2);
		controller.setOperation(Operation.SPREAD);
		controller.operate(path);
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
		controller.setColumn1(0);
		controller.setColumn2(1);
		controller.setColumn3(2);
		controller.setOperation(Operation.SPREAD);
		controller.operate(path);
		
		assertFalse(controller.getStreamIsOpen());
	}

	/**
	 * Get smallest absolute distance in football.csv
	 * Result is team Aston_Villa.
	 */
	@Test
	public void getSmallestAbsoluteDistance() {
		setPath("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		controller.setColumn1(0);
		controller.setColumn2(5);
		controller.setColumn3(6);
		controller.setOperation(Operation.ABSOLUTEDISTANCE);
		controller.operate(path);
		System.out.println(out);
		assertTrue((out.toString()).contains("Aston_Villa"));
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		assertFalse(controller.getStreamIsOpen());
	}
	
	/**
	 * Get smallest absolute distance from not existing file. No stream should be opened.
	 */
	@Test
	public void getSmallestAbsoluteDistanceFromNotExistingFile() {
		setPath("");
		controller.setColumn1(0);
		controller.setColumn2(5);
		controller.setColumn3(6);
		controller.setOperation(Operation.ABSOLUTEDISTANCE);
		controller.operate(path);
		
		assertFalse(controller.getStreamIsOpen());
	}

	private void setPath(String path) {
		this.path = path;
	}
}
