package edu.umb.cs680.hw12;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

        Car car1 = new Car("ABC","AAA",17,2019,25900.7f);
        Car car2 = new Car("DEF","BBB",12,2018,20000.9f);


    private String[] carToStringArray(Car car){
        String[] carInfo = {
                car.getModel(),
                car.getMake(),
                String.valueOf(car.getMileage()),
                String.valueOf(car.getYear()),
                String.valueOf(car.getPrice())
        };
        return carInfo;
    }

    @Test
    public void  verifyCarEqualityWithModelMakeMileageYearPrice(){
        String[] expected = {"ABC","AAA","17","2019","25900.7"};
        assertArrayEquals(expected,carToStringArray(car1));
    }

    @Test
    public void CheckInequalityWithTwoCarInstances(){

        assertNotEquals(carToStringArray(car1),carToStringArray(car2));
    }

}