/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils.cursor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.exceptions.FullListException;

/**
 *
 * @author Carlos
 */
public class OrderedListCursorTest {
    private final int size = 10;
    private OrderedListCursor<Integer> completa = new OrderedListCursor<>(size); //La llenamos entera
    private OrderedListCursor<Integer> mitad = new OrderedListCursor<>(size);    //La llenamos hasta
                                                                                 //la mitad
    
    private OrderedListCursor<Integer> vacia = new OrderedListCursor<>(0);   //Lista vacía
    private final int[] cases = {6, 7, 8, 9, 10};
    
    public OrderedListCursorTest() {
    }

    @Before
    public void setUp() {
        for (int i = 0; i < size; i++) {
            completa.add(i);
        }
        
        for (int i = 0; i < size/2; i++) {
            mitad.add(i);
        }
    }

    /**
     * Test of add method, of class OrderedListCursor.
     */
    @Test
    public void testAddFull() {
        System.out.println("Test add() with full capacity");
        assertThrows(FullListException.class, ()->{completa.add(cases[0]);});
    }
    
    /**
     * Test of add method, of class OrderedListCursor.
     */
    @Test
    public void testAdd() {
        System.out.println("Test add()");
        for(int num : cases) {
            mitad.add(num);
        }
        
        for(int num : cases) {
            assertEquals(true, mitad.contains(num));
        }
    }

    /**
     * Test of clear method, of class OrderedListCursor.
     */
    @Test
    public void testClear() {
        System.out.println("Test clear()");
        completa.clear();
        vacia.clear();
        
        assertEquals(true, completa.isEmpty());
        assertEquals(false, mitad.isEmpty());
        assertEquals(true, completa.isEmpty());
    }

    /**
     * Test of contains method, of class OrderedListCursor.
     */
    @Test
    public void testContains() {

    }

    /**
     * Test of isEmpty method, of class OrderedListCursor.
     */
    @Test
    public void testIsEmpty() {

    }

    /**
     * Test of remove method, of class OrderedListCursor.
     */
    @Test
    public void testRemove() {

    }
    
}
