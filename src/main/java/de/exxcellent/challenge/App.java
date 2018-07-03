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
		controller.setColumn1(0);
		controller.setColumn2(1);
		controller.setColumn3(2);
		controller.setOperation(Operation.SPREAD);
        controller.operate("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
		controller.setColumn1(0);
		controller.setColumn2(5);
		controller.setColumn3(6);
		controller.setOperation(Operation.ABSOLUTEDISTANCE);
        controller.operate("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");
        
    }
}
