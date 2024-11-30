package oop.practice;
public class Main {
    public static void main(String[] args) {

        Queue<String> carQueue = new SimpleQueue<>();
        carQueue.enqueue("Car1");
        carQueue.enqueue("Car2");
        carQueue.enqueue("Car3");

        Dineable peopleDinner = new PeopleDinner();
        Refuelable gasStation = new GasStation();

        CarStation peopleGasStation = new CarStation(carQueue, peopleDinner, gasStation);
        System.out.println("Processing cars for people and gas station:");
        peopleGasStation.processQueue();

        Queue<String> robotQueue = new SimpleQueue<>();
        robotQueue.enqueue("Car4");
        robotQueue.enqueue("Car5");

        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();

        CarStation robotElectricStation = new CarStation(robotQueue, robotDinner, electricStation);
        System.out.println("\nProcessing cars for robots and electric station:");
        robotElectricStation.processQueue();

        System.out.println("\nStatistics:");
        System.out.println("People served: " + ((PeopleDinner) peopleDinner).getPeopleServed());
        System.out.println("Robots served: " + ((RobotDinner) robotDinner).getRobotsServed());
        System.out.println("Gas cars refueled: " + ((GasStation) gasStation).getGasCarsRefueled());
        System.out.println("Electric cars refueled: " + ((ElectricStation) electricStation).getElectricCarsRefueled());
    }
}
