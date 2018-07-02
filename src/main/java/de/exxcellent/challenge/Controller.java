package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	private int column1;
	private int column2;
	private int column3;
	
	/**
	 * Default constructor. Has SimpleCSVParser as default parser. The default reader is a StreamReader. The default columns are 0, 1 and 2.
	 */
	public Controller() {
		this.setParser(new SimpleCSVParser());
		this.reader = new StreamReader();
		this.stream = null;
		this.streamIsOpen = false;
		this.column1 = 0;
		this.column2 = 1;
		this.column3 = 2;
	}
	
	private void open(String path) {
		if((stream = reader.openStream(path)) != null) {
			streamIsOpen = true;
		}
		else {
			streamIsOpen = false;
		}
	}

	public void getSmallestSpread(String path) {
		open(path);
		
		String line;
		String[] parsed;
		// default to day 0 if there is no valid data
		String day = "0";
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
						day = parsed[column1];
						smallestSpread = spread;
					}
				}	
				streamIsOpen = !reader.closeStream(stream);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(day == "0") {
			System.out.println("no valid data!");
		}
		else {
			System.out.println("Day with smallest temperature spread : " + day);
		}
	}
	
	private float getSpread(String[] parsed) {
		float spread = Float.parseFloat(parsed[column2].trim()) - Float.parseFloat(parsed[column3].trim());
		return spread;
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
}
