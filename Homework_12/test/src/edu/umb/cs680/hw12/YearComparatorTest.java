package edu.umb.cs680.hw12;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YearComparatorTest {

    static ArrayList<Car> carList = new ArrayList<>();
    @BeforeAll
    static void  SetUpCarList(){
        carList.add(new Car("ABC","AAA",17,2019,25900.7f));
        carList.add(new Car("DEF","BBB",12,2018,20000.9f));
        carList.add(new Car("GHI","CCC",23,2021,23000.5f));
        carList.add(new Car("JKL","DDD",19,2022,31000.2f));
        carList.add(new Car("MNO","EEE",18,2003,15700.0f));
        carList.add(new Car("PQR","FFF",13,2008,19600.5f));
        carList.add(new Car("STU","GGG",19,2009,17300.0f));
        carList.add(new Car("VWX","HHH",21,2021,29400.3f));
        carList.add(new Car("YZ","III",15,2017,20500.2f));
    }

    private List<Integer> yearToIntegerArray(List<Car> carList) {
        List<Integer> carPriceInfo = new ArrayList();;
        for (Car car : carList){
            carPriceInfo.add(car.getYear());
        }
        return carPriceInfo;
    }

    @Test
    public void checkYearComparator() {

        List<Integer> expected = Arrays.asList(2003, 2008, 2009, 2017, 2018, 2019, 2021, 2021, 2022);
        Collections.sort(carList,new YearComparator()); //Sorting based on Year Comparator
        List<Integer> actual = yearToIntegerArray(carList);
        assertEquals(expected, actual);
    }

}