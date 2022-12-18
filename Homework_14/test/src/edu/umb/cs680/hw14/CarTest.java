package edu.umb.cs680.hw14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
@SuppressWarnings("unchecked")

public class CarTest {
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

    @Test
    public void checkMileageComparator() {

        List<Integer> expected = Arrays.asList(12, 13, 15,17,18,19,19,21,23);
        ArrayList<Car> carMileageList;
        carMileageList = carList;
        Collections.sort(carMileageList, (Car car1, Car car2) -> car1.getMileage() - car2.getMileage()); //Sorting based on Mileage Comparator
        List<Integer> actual = new ArrayList();
        for (Car car : carMileageList){
            actual.add(car.getMileage());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void checkParetoComparator() {
        List<String> expected = Arrays.asList("MNO", "PQR", "STU", "YZ", "DEF", "ABC", "GHI", "VWX", "JKL");
        ArrayList<Car> carParetoList;
        carParetoList = carList;
        Collections.sort(carParetoList, (Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount()); //Sorting based on Pareto Comparator
        List<String> actual = new ArrayList();
        for (Car car : carParetoList){
            actual.add(car.getModel());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void checkPriceComparator() {

        List<Float> expected = Arrays.asList(15700.0f, 17300.0f, 19600.5f, 20000.9f, 20500.2f, 23000.5f, 25900.7f, 29400.3f, 31000.2f);
        ArrayList<Car> carPriceList;
        carPriceList = carList;
        Collections.sort(carPriceList, (Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice())); //Sorting based on Price Comparator
        List<Float> actual = new ArrayList();
        for (Car car : carPriceList){
            actual.add(car.getPrice());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void checkYearComparator() {

        List<Integer> expected = Arrays.asList(2003, 2008, 2009, 2017, 2018, 2019, 2021, 2021, 2022);
        ArrayList<Car> carYearList;
        carYearList = carList;
        Collections.sort(carYearList, (Car car1, Car car2) -> (car1.getYear() - car2.getYear())); //Sorting based on Price Comparator
        List<Integer> actual = new ArrayList();
        for (Car car : carYearList){
            actual.add(car.getYear());
        }
        assertEquals(expected, actual);
    }
}
