package oop.practice;

public class RobotDinner implements Dineable {
    private int robotsServed = 0;

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to robots in car " + carId + ".");
        robotsServed++;
    }

    public int getRobotsServed() {
        return robotsServed;
    }
}