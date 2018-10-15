import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    //сумма двух сторон больше третьей
    public void check1() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(9,11,8);
        assertEquals(actual, true);
    }
    @Test
    //сумма двух сторон меньше третьей
    public void check2() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(22,5,3);
        assertEquals(actual, false);
    }
    @Test
    //равнобедренный треугольник(сумма двух сторон больше третьей)
    public void check3() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(8,8,10);
        assertEquals(actual, true);
    }
    @Test
    //равнобедренный треугольник(сумма двух сторон меньше третьей)
    public void check4() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(8,8,20);
        assertEquals(actual, false);
    }
    @Test
    //равносторонний треугольник(длины сторон положительные)
    public void check5() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(5,5,5);
        assertEquals(actual, true);
    }
    @Test
    //равносторонний треугольник(длины сторон отрицательные)
    public void check6() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(-5,-5,-5);
        assertEquals(actual, false);
    }
    @Test
    //прямоугольный треугольник
    public void check7() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(5,4,3);
        assertEquals(actual, true);
    }
    @Test
    //сумма двух сторон равна третьей
    public void check8() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(10,4,6);
        assertEquals(actual, false);
    }
    @Test
    //длина одной из сторон равно 0
    public void check9() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(0,4,6);
        assertEquals(actual, false);
    }
    @Test
    //длина одной из сторон отрицательная
    public void check10() {
        Triangle triangle = new Triangle();
        boolean actual = triangle.check(-6,4,6);
        assertEquals(actual, false);
    }
}