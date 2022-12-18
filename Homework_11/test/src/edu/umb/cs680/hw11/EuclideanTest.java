package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EuclideanTest {
	List<Double> point1 = Arrays.asList(-1.0, -1.0, -1.0);
	List<Double> point2 = Arrays.asList(2.0, 2.0, 2.0);

	@Test
	public void checkEuclideanDistanceBetweenPoint1AndPoint2() {

		double expected = Math.sqrt(27.0);
		double actual = new Euclidean().distance(point1, point2);
		assertEquals(expected, actual);
	}
}