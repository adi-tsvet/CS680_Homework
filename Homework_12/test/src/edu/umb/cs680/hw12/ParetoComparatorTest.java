package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParetoComparatorTest {

    static ArrayList<Car> carList = new ArrayList<>();
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

        for (Car car : carList) {
            car.setDominationCount(carList);
        } //Adding Domination value to each car info
    }

    private List<String> paretoToStringArray(List<Car> carList) {
        List<String> carModelInfo = new ArrayList();;
        for (Car car : carList){
            carModelInfo.add(car.getModel());
        }
        return carModelInfo;
    }

    @Test
    public void checkParetoComparator() {

        List<String> expected = Arrays.asList("DEF", "ABC", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ");
        Collections.sort(carList,new ParetoComparator()); //Sorting based on Pareto Comparator
        List<String> actual = paretoToStringArray(carList);
        assertEquals(expected, actual);
    }
}