package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private String[] carToStringArray(Car car){
        String[] carInfo = {
                car.getMake(),
                car.getModel(),
                String.valueOf(car.getYear())
        };
        return carInfo;
    }


    @Test
    public void  verifyCarEqualityWithMakeModelYear(){
        String[] expected = {"Toyota","RAV4", "2018"};
        Car actual = new Car("Toyota","RAV4",2018);
        assertArrayEquals(expected,carToStringArray(actual));

    }

    @Test
    public void CheckInequalityWithTwoCarInstances(){

        Car car1 = new Car("BMW", "X7", 2022);
        Car car2 = new Car("BMW", "X3", 2021);
        assertNotEquals(carToStringArray(car1),carToStringArray(car2));
    }
}

