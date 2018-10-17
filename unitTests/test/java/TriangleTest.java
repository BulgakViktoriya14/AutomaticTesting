import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void sumOfTheTwoSidesIsGreaterThanTheThird() {
        assertEquals(new Triangle().check(9,11,8), true);
    }
    @Test
    public void sumOfTheTwoSidesIsLessThanTheThird() {
        assertEquals(new Triangle().check(22,5,3), false);
    }
    @Test
    public void isoscelesTriangleWithSumOfTheTwoSidesIsGreaterThanTheThird() {
         assertEquals(new Triangle().check(8,8,10), true);
    }
    @Test
    public void isoscelesTriangleWithSumOfTheTwoSidesIsLessThanTheThird() {
        assertEquals(new Triangle().check(8,8,20), false);
    }
    @Test
    public void equilateralTriangleWithPositiveSides() {
        assertEquals(new Triangle().check(5,5,5), true);
    }
    @Test
    public void equilateralTriangleWithNegativeSides() {
        assertEquals(new Triangle().check(-5,-5,-5), false);
    }
    @Test
    public void rightTriangle() {
        assertEquals(new Triangle().check(5,4,3), true);
    }
    @Test
    public void sumOfTheTwoSidesIsEqualToTheThird() {
        assertEquals( new Triangle().check(10,4,6), false);
    }
    @Test
    public void lengthOfOneOfTheSidesIsZero() {
        assertEquals(new Triangle().check(0,4,6), false);
    }
    @Test
    public void lengthOfOneOfTheSidesIsNegative() {
        assertEquals(new Triangle().check(-6,4,6), false);
    }
}