package edu.umb.cs680.hw16;

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

	// Distance Metric Declaration
	static DistanceMetric euclideanMetric;
	static DistanceMetric manhattanMetric;
	static DistanceMetric chebyshevMetric;


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

		// LAMBDA EXPRESSION FOR ALL THE DISTANCE METRIC
		euclideanMetric = (p1, p2) -> {
			double sumOfSquared = 0.0;
			for (int i = 0; i < p1.size(); i++) {
				sumOfSquared += Math.pow( p1.get(i)-p2.get(i), 2 );
			}
			return Math.sqrt(sumOfSquared);
		}; // DistanceMetric distance uses Euclidean calculation

		manhattanMetric = (p1, p2) -> {
			double sumOfCoordinates = 0;
			for (int i = 0; i < p1.size(); i++) {
				sumOfCoordinates += Math.abs(p1.get(i) - p2.get(i));
			}
			return sumOfCoordinates;
		}; // DistanceMetric distance uses Manhattan calculation

		chebyshevMetric  = (p1, p2) -> {
			double maxCoordiante = 0;
			for (int i = 0; i < p1.size(); i++)
			{
				double temp = Math.abs(p1.get(i) - p2.get(i));
				if(temp > maxCoordiante)
				{
					maxCoordiante = temp;
				}
			}
			return maxCoordiante;
		}; // DistanceMetric distance uses Chebyshev calculation
	}

	@Test
	public void checkDistanceMatrixWithSixPointsFromListWithEuclideanMetric() {
		Double[][] expected = {
				{0.0, Math.sqrt(3.0), Math.sqrt(12.0), Math.sqrt(3.0), Math.sqrt(19.0), Math.sqrt(10.0)},
				{Math.sqrt(3.0), 0.0, Math.sqrt(3.0), Math.sqrt(12.0), Math.sqrt(8.0), Math.sqrt(5.0)},
				{Math.sqrt(12.0), Math.sqrt(3.0), 0.0, Math.sqrt(27.0), Math.sqrt(3.0), Math.sqrt(6.0)},
				{Math.sqrt(3.0), Math.sqrt(12.0), Math.sqrt(27.0), 0.0, 6.0, Math.sqrt(21.0)},
				{Math.sqrt(19.0), Math.sqrt(8.0), Math.sqrt(3.0), 6.0, 0.0, Math.sqrt(5.0)},
				{Math.sqrt(10.0), Math.sqrt(5.0), Math.sqrt(6.0), Math.sqrt(21.0), Math.sqrt(5.0), 0.0},
		};
		List<List<Double>> actual = Distance.matrix(pointsList,euclideanMetric);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}


	@Test
	public void checkEuclideanDistanceBetweenPoint6AndPoint2() {

		double expected = Math.sqrt(5.0);
		double actual = Distance.get(point6, point2, euclideanMetric); // DistanceMetric distance uses Euclidean calculation
		assertEquals(expected, actual);
	}

	@Test
	public void checkManhattanDistanceBetweenPoint1AndPoint2() {

		double expected = 3.0;
		double actual = Distance.get(point1, point2, manhattanMetric); // DistanceMetric distance uses Manhattan calculation
		assertEquals(expected, actual);
	}

	@Test
	public void checkChebyshevDistanceBetweenPoint3AndPoint4() {

		double expected = 3.0;
		double actual = Distance.get(point3, point4, chebyshevMetric); // DistanceMetric distance uses Chebyshev calculation
		assertEquals(expected, actual);
	}

	@Test
	public void checkDistanceMatrixWithSixPointsFromListWithManhattanMetric() {
		Double[][] expected = {
								{0.0, 3.0, 6.0, 3.0, 7.0, 4.0},
								{3.0, 0.0, 3.0, 6.0, 4.0, 3.0},
								{6.0, 3.0, 0.0, 9.0, 3.0, 4.0},
								{3.0, 6.0, 9.0, 0.0, 10.0, 7.0},
								{7.0, 4.0, 3.0, 10.0, 0.0, 3.0},
								{4.0, 3.0, 4.0, 7.0, 3.0, 0.0}
								};
		List<List<Double>> actual = Distance.matrix(pointsList,manhattanMetric);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

	@Test
	public void checkDistanceMatrixWithSixPointsFromListWithChebyshevMetric() {
		Double[][] expected = {
								{0.0, 1.0, 2.0, 1.0, 3.0, 3.0},
								{1.0, 0.0, 1.0, 2.0, 2.0, 2.0},
								{2.0, 1.0, 0.0, 3.0, 1.0, 2.0},
								{1.0, 2.0, 3.0, 0.0, 4.0, 4.0},
								{3.0, 2.0, 1.0, 4.0, 0.0, 2.0},
								{3.0, 2.0, 2.0, 4.0, 2.0, 0.0}
							};
		List<List<Double>> actual = Distance.matrix(pointsList,chebyshevMetric);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
}