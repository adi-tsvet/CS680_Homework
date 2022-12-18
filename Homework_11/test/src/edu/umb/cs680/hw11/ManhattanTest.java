package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ManhattanTest{

	List<Double> point1 = Arrays.asList (1.0, 1.0, 1.0);
	List<Double> point2 = Arrays.asList(0.0, -2.0, -2.0);

	@Test
	public void checkManhattanDistanceBetweenPoint1AndPoint2()
	{
		double expected = 7.0;
		double actual = new Manhattan().distance(point1, point2);
		assertEquals(expected, actual);
	}
}