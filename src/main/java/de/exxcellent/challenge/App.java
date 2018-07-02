package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        Controller controller = new Controller();
        controller.getSmallestSpread("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
        
    }
}
