package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class Car {

    private String model, make;
    private int mileage, year;
    private float price;
    private int dominationCount;


    public Car(String model, String make, int mileage, int year, float price) {
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public void setDominationCount(ArrayList<Car> carList) {
        int count = 0;
        for (Car car : carList) {
            if (!car.equals(this)) {
                if ((this.getYear() >= car.getYear()) && (this.getMileage() <= car.getMileage()) && (this.getPrice() <= car.getPrice())) {
                    if ((this.getYear() > car.getYear()) || (this.getMileage() < car.getMileage()) || (this.getPrice() < car.getPrice())) {
                        count++;
                    }
                }
            }
        }
        this.dominationCount = count;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }



}
