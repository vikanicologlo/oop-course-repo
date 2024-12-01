package oop.practice;
public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Queue<Car> queue, Dineable diningService, Refuelable refuelingService) {
        this.queue = queue;
        this.diningService = diningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            refuelingService.refuel(car.getCarId());
            diningService.serveDinner(car.getCarId());
        }
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }
}