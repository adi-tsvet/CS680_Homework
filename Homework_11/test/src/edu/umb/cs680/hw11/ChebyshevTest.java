package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChebyshevTest {

	List<Double> point1 = Arrays.asList(0.0, 0.0, 0.0);
	List<Double> point2 = Arrays.asList(0.0, -2.0, -2.0);

	@Test
	public void checkChebyshevDistanceBetweenPoint1AndPoint2() {
		double expected = 2.0;
		double actual = new Chebyshev().distance(point1, point2);
		assertEquals(expected, actual);
	}
}