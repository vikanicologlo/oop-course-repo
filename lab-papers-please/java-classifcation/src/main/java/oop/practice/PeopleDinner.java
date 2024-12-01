package oop.practice;

public class PeopleDinner implements Dineable {
    private int peopleServed = 0;

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to people in car " + carId + ".");
        peopleServed++;
    }

    public int getPeopleServed() {
        return peopleServed;
    }
}






