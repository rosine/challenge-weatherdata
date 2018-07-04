package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.exxcellent.challenge.Parser.Parser;
import de.exxcellent.challenge.Parser.SimpleCSVParser;
import de.exxcellent.challenge.Reader.Reader;
import de.exxcellent.challenge.Reader.StreamReader;

/**
 * The class controlling reading data bases and operating them.
 * @author Bettina Weller
 *
 */
public class Controller {
	private InputStream stream;
	private Parser parser;
	private boolean streamIsOpen;
	private Reader reader;
	//to be printed value
	private int column1;
	//value 1 for operation
	private int column2;
	//value 2 for operation
	private int column3;
	// to be executed operation
	private Operation operation;
	
	/**
	 * Default constructor.
	 * Has SimpleCSVParser as default parser.
	 * The default reader is a StreamReader.
	 * The default columns are 0, 1 and 2.
	 * The default operation is spread.
	 */
	public Controller() {
		this.setParser(new SimpleCSVParser());
		this.reader = new StreamReader();
		this.stream = null;
		this.streamIsOpen = false;
		this.column1 = 0;
		this.column2 = 1;
		this.column3 = 2;
		this.operation = Operation.SPREAD;
	}
	
	private void open(String path) {
		if((stream = reader.openStream(path)) != null) {
			streamIsOpen = true;
		}
		else {
			streamIsOpen = false;
		}
	}

	/**
	 * Opens given file and operates according to operation.
	 * @param path to be operated file
	 */
	public void operate(String path) {
		open(path);
		switch(this.operation) {
			case SPREAD: 
				getSmallestSpread();
				break;
			case ABSOLUTEDISTANCE:
				getSmallestAbsoluteDistance();
				break;
			default: 
				System.out.println("No valid operation!");
				break;
		}
	}
	
	/**
	 * Searches for the smallest spread in stream.
	 * @param path to be searched file
	 */
	private void getSmallestSpread() {
		String line;
		String[] parsed;
		// default to day 0 if there is no valid data
		String output = "0";
		float smallestSpread = Float.MAX_VALUE;
		try {
			if(streamIsOpen) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.stream));
				//skip title line
					line = bufferedReader.readLine();
				//save first line as smallestSpread
				//iterate over other lines
				//if multiple lines have the smallest spread the first one found is used
				while((line = bufferedReader.readLine()) != null) {
					parsed = parser.parse(line);
					float spread;
					if((spread = getSpread(parsed)) < smallestSpread) {
						output = parsed[column1];
						smallestSpread = spread;
					}
				}	
				streamIsOpen = !reader.closeStream(stream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(output == "0") {
			System.out.println("no valid data!");
		}
		else {
			System.out.println("Day with smallest temperature spread : " + output);
		}
	}
	
	/**
	 * Searches for the smallest absolute distance in stream.
	 * @param path to be searched file
	 */
	private void getSmallestAbsoluteDistance() {
		String line;
		String[] parsed;
		// default to day 0 if there is no valid data
		String output = "0";
		int smallestAbsoluteDistance = Integer.MAX_VALUE;
		try {
			if(streamIsOpen) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.stream));
				//skip title line
					line = bufferedReader.readLine();
				//save first line as smallestSpread
				//iterate over other lines
				//if multiple lines have the smallest spread the first one found is used
				while((line = bufferedReader.readLine()) != null) {
					parsed = parser.parse(line);
					int absoluteDistance;
					if((absoluteDistance = getAbsoluteDistance(parsed)) < smallestAbsoluteDistance) {
						output = parsed[column1];
						smallestAbsoluteDistance = absoluteDistance;
					}
				}	
				streamIsOpen = !reader.closeStream(stream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(output == "0") {
			System.out.println("no valid data!");
		}
		else {
			System.out.println("Team with smallest goal spread : " + output);
		}
	}
	
	/**
	 * Calculates the spread for given data.
	 * @param parsed contains to be used data
	 * @return spread of given data
	 */
	private float getSpread(String[] parsed) {
		float spread = Float.parseFloat(parsed[column2].trim()) - Float.parseFloat(parsed[column3].trim());
		return spread;
	}
	
	private int getAbsoluteDistance(String[] parsed) {
		int distance = (int) Math.abs(getSpread(parsed));
		return distance;
	}
	
	public boolean getStreamIsOpen() {
		return streamIsOpen;
	}

	public int getColumn1() {
		return column1;
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public void setColumn1(int column1) {
		this.column1 = column1;
	}

	public int getColumn2() {
		return column2;
	}

	public void setColumn2(int column2) {
		this.column2 = column2;
	}

	public int getColumn3() {
		return column3;
	}

	public void setColumn3(int column3) {
		this.column3 = column3;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
}
