package oop.practice;

public class Semaphore {
    private CarStation gasCarStation;
    private CarStation electricCarStation;

    public Semaphore(CarStation gasCarStation, CarStation electricCarStation) {
        this.gasCarStation = gasCarStation;
        this.electricCarStation = electricCarStation;
    }

    public void assignCarToStation(Car car) {
        if (car.getFuelType() == FuelType.GAS) {
            gasCarStation.addCar(car);
        } else if (car.getFuelType() == FuelType.ELECTRIC) {
            electricCarStation.addCar(car);
        }
    }
}
