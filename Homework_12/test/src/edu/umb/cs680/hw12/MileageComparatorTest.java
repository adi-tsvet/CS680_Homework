package edu.umb.cs680.hw12;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MileageComparatorTest {

    static ArrayList<Car> carList = new ArrayList<Car>();
    @BeforeAll
    static void  SetUpCarList(){
        carList.add(new Car("ABC","AAA",17,2019,25900));
        carList.add(new Car("DEF","BBB",12,2018,20000));
        carList.add(new Car("GHI","CCC",23,2021,23000));
        carList.add(new Car("JKL","DDD",19,2022,31000));
        carList.add(new Car("MNO","EEE",18,2003,15700));
        carList.add(new Car("PQR","FFF",13,2008,19600));
        carList.add(new Car("STU","GGG",19,2009,17300));
        carList.add(new Car("VWX","HHH",21,2021,29400));
        carList.add(new Car("YZ","III",15,2017,20500));
    }

    private List<Integer> mileageToIntegerArray(List<Car> carList) {
        List<Integer> carMileageInfo = new ArrayList();
        for (Car car : carList){
            carMileageInfo.add(car.getMileage());
        }
        return carMileageInfo;
    }

    @Test
    public void checkMileageComparator() {

        List<Integer> expected = Arrays.asList(12, 13, 15, 17, 18, 19, 19, 21, 23);
        Collections.sort(carList,new MileageComparator()); //Sorting based on Mileage Comparator
        List<Integer> actual = mileageToIntegerArray(carList);
        assertEquals(expected, actual);
    }

}