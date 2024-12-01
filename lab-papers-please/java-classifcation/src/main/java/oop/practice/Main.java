package oop.practice;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CarStation gasStation = new CarStation(new SimpleQueue<>(), new PeopleDinner(), new GasStation());
        CarStation electricStation = new CarStation(new SimpleQueue<>(), new RobotDinner(), new ElectricStation());


        Semaphore semaphore = new Semaphore(gasStation, electricStation);


        CarReader carJsonReader = new CarReader();
        String filePath = "cars.json";
        List<Car> cars = carJsonReader.readCarsFromJson(filePath);


        if (cars != null) {
            for (Car car : cars) {
                semaphore.assignCarToStation(car);
            }
        }

        System.out.println("Before serving cars:");
        System.out.println("Gas Car Station Queue: " + gasStation.getQueueSize());
        System.out.println("Electric Car Station Queue: " + electricStation.getQueueSize());


        System.out.println("\nServing cars in gas station:");
        gasStation.serveCars();

        System.out.println("\nServing cars in electric station:");
        electricStation.serveCars();

        System.out.println("\nAfter serving cars:");
        System.out.println("Gas Car Station Queue: " + gasStation.getQueueSize());
        System.out.println("Electric Car Station Queue: " + electricStation.getQueueSize());

        if (gasStation.getRefuelable() instanceof GasStation) {
            System.out.println("\nGas cars refueled: " + ((GasStation) gasStation.getRefuelable()).getGasCarsRefueled());
        }


        if (electricStation.getRefuelable() instanceof ElectricStation) {
            System.out.println("Electric cars refueled: " + ((ElectricStation) electricStation.getRefuelable()).getElectricCarsRefueled());
        }


        if (gasStation.getDineable() instanceof PeopleDinner) {
            System.out.println("People served: " + ((PeopleDinner) gasStation.getDineable()).getPeopleServed());
        }

        if (electricStation.getDineable() instanceof RobotDinner) {
            System.out.println("Robots served: " + ((RobotDinner) electricStation.getDineable()).getRobotsServed());
        }
    }
}
