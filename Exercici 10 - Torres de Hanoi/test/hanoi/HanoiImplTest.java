/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hanoi;

import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class HanoiImplTest {

    private Stack<Integer> a;
    private Stack<Integer> b;
    private Stack<Integer> c;
    private Stack<Integer> copyAInit;
    private int h;

    @Before
    public void setUp() {
        a = new Stack<>();
        b = new Stack<>();
        c = new Stack<>();
        h = 5;
        for (int i = h; i > 0; i--) {
            a.push(i);
        }
        copyAInit = (Stack<Integer>) a.clone();
    }

    /**
     * Test of recursiuHanoi method, of class HanoiImpl.
     * Pensau que passi aquest test, no vol dir que el Hanoi funcioni bé,
     * ja que bastaria que el mètode fes swap(a,c). 
     * Afegiu nous tests
     */
    @Test
    public void testRecursiuHanoi() {
        System.out.println("recursiuHanoi");
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi<Integer> pHanoi = new HanoiImpl<>();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

//    /**
//     * Test of iteratiuHanoi method, of class HanoiImpl.
//     * Pensau que passi aquest test, no vol dir que el Hanoi funcioni bé,
//     * ja que bastaria que el mètode fes swap(a,c).
//     * Afegiu nous tests
//     */
//    @Test
//    public void testIteratiuHanoi() {
//        System.out.println("iteratiuHanoi");
//        assertEquals(true, a.equals(copyAInit));
//        assertEquals(true, b.isEmpty());
//        assertEquals(true, c.isEmpty());
//        Hanoi<Integer> pHanoi = new HanoiImpl<>();
//        pHanoi.iteratiuHanoi(h, a, b, c);
//        assertEquals(true, a.isEmpty());
//        assertEquals(true, b.isEmpty());
//        assertEquals(true, c.equals(copyAInit));
//    }


}
