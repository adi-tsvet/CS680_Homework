package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest {

	private static List<Double> point1, point2, point3, point4, point5, point6;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void createPointsLists() {

		point1 = Arrays.asList(1.0, 1.0, 1.0);
		point2 = Arrays.asList(0.0, 0.0, 0.0);
		point3 = Arrays.asList(-1.0, -1.0, -1.0);
		point4 = Arrays.asList(2.0, 2.0, 2.0);
		point5 = Arrays.asList(0.0, -2.0, -2.0);
		point6 = Arrays.asList(1.0, 0.0, -2.0);

		pointsList.add(point1);
		pointsList.add(point2);
		pointsList.add(point3);
		pointsList.add(point4);
		pointsList.add(point5);
		pointsList.add(point6);
	}

	@Test
	public void checkDistanceMatrixWithSixPointsFromList() {
		Double[][] expected = {
				{ 0.0, Math.sqrt(3.0), Math.sqrt(12.0), Math.sqrt(3.0), Math.sqrt(19.0), Math.sqrt(10.0) },
				{ Math.sqrt(3.0), 0.0, Math.sqrt(3.0) , Math.sqrt(12.0), Math.sqrt(8.0), Math.sqrt(5.0) },
				{ Math.sqrt(12.0), Math.sqrt(3.0), 0.0 , Math.sqrt(27.0), Math.sqrt(3.0), Math.sqrt(6.0) },
				{ Math.sqrt(3.0), Math.sqrt(12.0), Math.sqrt(27.0), 0.0, 6.0, Math.sqrt(21.0) },
				{ Math.sqrt(19.0), Math.sqrt(8.0), Math.sqrt(3.0), 6.0, 0.0, Math.sqrt(5.0) },
				{ Math.sqrt(10.0), Math.sqrt(5.0), Math.sqrt(6.0), Math.sqrt(21.0), Math.sqrt(5.0), 0.0 },
		};
		List<List<Double>> actual = Distance.matrix(pointsList);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

	@Test
	public void checkDistanceBetweenPoint4AndPoint5UsingDefaultFunction() {
		double expected = 6.0;
		double actual = Distance.get(point4, point5); //Default function uses Euclidean function
		assertEquals(expected, actual);
	}

	@Test
	public void checkDistanceBetweenPoint4AndPoint5UsingEuclidean() {
		double expected = 6.0;
		double actual = Distance.get(point4, point5, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void checkDistanceBetweenPoint6AndPoint2UsingDefaultFunction() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(point6, point2); //Default function uses Euclidean function
		assertEquals(expected, actual);
	}
}