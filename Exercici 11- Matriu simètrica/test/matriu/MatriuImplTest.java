/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package matriu;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class MatriuImplTest {
    private MatriuImpl<Integer> m1;
    private MatriuImpl<Integer> m2;
    private MatriuImpl<Integer> m3;

    private MatriuImpl<Character> c1;
    private MatriuImpl<Character> c2;
    private MatriuImpl<Character> c3;

    @Before
    public void setUp() throws Exception {
        Integer[] matriu1 = {0,1,2,1,1,2,2,2,3};
        Integer[] matriu2 = {0,1,2,3,1,2,2,2,3};
        Integer[] matriu3 = {0,1,2,1,1,2};
        m1 = new MatriuImpl<>(matriu1,3,3);
        m2 = new MatriuImpl<>(matriu2,3,3);
        m3 = new MatriuImpl<>(matriu3,2,3);
    }

    
    /**
     * Test of isSymmetricalRecursiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalRecursiu() {
        System.out.println("isSymmetricalRecursiu");
        assertEquals(true, m1.isSymmetricalRecursiu());
        assertEquals(false, m2.isSymmetricalRecursiu());
        assertEquals(false, m3.isSymmetricalRecursiu());
    }

    /**
     * Test of isSymmetricalIteratiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalIteratiu() {
        System.out.println("isSymmetricalIteratiu");
        assertEquals(true, m1.isSymmetricalIteratiu());
        assertEquals(false, m2.isSymmetricalIteratiu());
        assertEquals(false, m3.isSymmetricalIteratiu());
    }


    Character[] matriu1 = {'c', 'a', 'r', 'a', 'l', 'o', 'r', 'o', 's'};
    Character[] matriu2 = {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd'};
    Character[] matriu3 = {'u'};


    @Test
    public void testIsSymmetricalRecuriusCharacter() {
        System.out.println("isSymmetricalRecursiuCharacter");
        c1 = new MatriuImpl<>(matriu1, 3, 3);
        c2 = new MatriuImpl<>(matriu2, 4, 4);
        c3 = new MatriuImpl<>(matriu3, 1, 1);
        assertTrue(c1.isSymmetricalIteratiu());
        assertFalse(c2.isSymmetricalIteratiu());
        assertTrue(c3.isSymmetricalIteratiu());
    }

    @Test
    public void testIsSymmetricalIteratiuCharacter() {
        System.out.println("isSymmetricalIteratiuCharacter");
        c1 = new MatriuImpl<>(matriu1, 3, 3);
        c2 = new MatriuImpl<>(matriu2, 4, 4);
        c3 = new MatriuImpl<>(matriu3, 1, 1);
        assertTrue(c1.isSymmetricalIteratiu());
        assertFalse(c2.isSymmetricalIteratiu());
        assertTrue(c3.isSymmetricalIteratiu());
    }
}
