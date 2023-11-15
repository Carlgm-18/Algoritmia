
package peak;

import java.awt.Point;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Class that gather all the tests for the
 * {@code PeakImpl} class.
 * 
 * @author Carlos Gálvez, Unai Pueyo
 */
public class PeakImplTest {
    
    private static Peak p;
    
    @Before
    public void setAll() {
        p = new PeakImpl();
    }

    private int[] generateCase(int size, int posMax, int max) {
        int[] ret = new int[size];
        ret[posMax] = max;
        for (int i = 0, j = max - posMax; i < posMax; i++, j++) {
            ret[i] = j;
        }

        for (int i = posMax+1; i < size; i++) {
            ret[i] = max - i;
        }
        return ret;
    }

    private int[] functionParabola(int a, int b, int c, int limLeft, int limRight) {
        int[] ret = new int[limRight - limLeft];
        for (int i = 0, j = limLeft; i < ret.length; i++, j++) {
            ret[i] = a*j*j + b*j + c;
        }
        return ret;
    }
    /**
     * A simple test of peak method, of class PeakImpl.
     */
    @Test
    public void testPeak() {
        System.out.print("peak ");
        int[] a = {1,3,5,7,8,5,2,1};
        Point expResult = new Point(8,4);
        Point result = p.peak(a);
        assertEquals(expResult, result);
        System.out.println("passed");
    }

    @Test
    public void testPeakSmallSize() {
        System.out.print("peak small ");
        int[] a = generateCase(100, 34, 50);
        Point expResult = new Point(50,34);
        Point result = p.peak(a);
        assertEquals(expResult, result);
        System.out.println("passed");
    }

    @Test
    public void testPeakMediumSize() {
        System.out.print("peak medium ");
        int[] a = generateCase(10000, 6732, 3333);
        Point expResult = new Point(3333,6732);
        Point result = p.peak(a);
        assertEquals(expResult, result);
        System.out.println("passed");
    }

    @Test
    public void testPeakLargeSize() {
        System.out.print("peak large ");
        int[] a = generateCase(1000000, 123456, 7);
        Point expResult = new Point(7,123456);
        Point result = p.peak(a);
        assertEquals(expResult, result);
        System.out.println("passed");
    }

    @Test
    public void testGenericParabola() {
        System.out.print("peak generic parabola ");
        int[] a = functionParabola(-1, 4, 10, -50, 50);
        Point expResult = new Point(14,52);
        Point result = p.peak(a);
        assertEquals(expResult, result);
        System.out.println("passed");
    }

}
