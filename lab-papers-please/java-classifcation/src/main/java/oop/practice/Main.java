package oop.practice;

public class Main {
    public static void main(String[] args) {

        Queue<Car> peopleQueue = new SimpleQueue<>();
        peopleQueue.enqueue(new Car("Car1"));
        peopleQueue.enqueue(new Car("Car2"));


        Dineable peopleDinner = new PeopleDinner();
        Refuelable gasStation = new GasStation();

        CarStation peopleGasStation = new CarStation(peopleQueue, peopleDinner, gasStation);


        System.out.println("Processing cars for people and gas station:");
        peopleGasStation.serveCars();


        Queue<Car> robotQueue = new SimpleQueue<>();
        robotQueue.enqueue(new Car("Car3"));
        robotQueue.enqueue(new Car("Car4"));


        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();


        CarStation robotElectricStation = new CarStation(robotQueue, robotDinner, electricStation);


        System.out.println("\nProcessing cars for robots and electric station:");
        robotElectricStation.serveCars();

        System.out.println("\nStatistics:");
        System.out.println("People served: " + ((PeopleDinner) peopleDinner).getPeopleServed());
        System.out.println("Robots served: " + ((RobotDinner) robotDinner).getRobotsServed());
        System.out.println("Gas cars refueled: " + ((GasStation) gasStation).getGasCarsRefueled());
        System.out.println("Electric cars refueled: " + ((ElectricStation) electricStation).getElectricCarsRefueled());
    }
}
