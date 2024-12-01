package oop.practice;

public class Car {
    private String id;
    private FuelType fuelType;

    public Car(String id, FuelType fuelType) {
        this.id = id;
        this.fuelType = fuelType;
    }

    public String getId() {
        return id;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
