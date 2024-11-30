package oop.practice;


public class ElectricStation implements Refuelable {
    private int electricCarsRefueled = 0;

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId + ".");
        electricCarsRefueled++;
    }

    public int getElectricCarsRefueled() {
        return electricCarsRefueled;
    }
}
