package oop.practice;

public class CarStation {
    private Queue<Car> queue;
    private Dineable dineable;
    private Refuelable refuelable;

    public CarStation(Queue<Car> queue, Dineable dineable, Refuelable refuelable) {
        this.queue = queue;
        this.dineable = dineable;
        this.refuelable = refuelable;
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            refuelable.refuel(car.getId());
            dineable.serveDinner(car.getId());
        }
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public int getQueueSize() {
        return queue.size();
    }
    public Refuelable getRefuelable() {
        return refuelable;
    }

    public Dineable getDineable() {
        return dineable;
    }
}
