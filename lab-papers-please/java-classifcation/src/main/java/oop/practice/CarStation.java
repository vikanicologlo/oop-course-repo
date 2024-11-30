package oop.practice;

public class CarStation {
    private Queue<String> queue;
    private Dineable dineable;
    private Refuelable refuelable;

    public CarStation(Queue<String> queue, Dineable dineable, Refuelable refuelable) {
        this.queue = queue;
        this.dineable = dineable;
        this.refuelable = refuelable;
    }

    public void processQueue() {
        while (!queue.isEmpty()) {
            String carId = queue.dequeue();
            refuelable.refuel(carId);
            dineable.serveDinner(carId);
        }
    }
}
