
package heap;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class HeapSortImplTest {
    
    public HeapSortImplTest() {
    }

    /**
     * Test of heapSort method, of class HeapSortImpl.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");
        Integer a[] = new Integer[100];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    @Test
    public void testHeapSortCharacters() {
        System.out.println("heapSortCharacter");
        Character[] a = {'h', 'o', 'y', 'm', 'e', 'v', 'o', 'y', 'a', 'l', 's', 'o', 'l'};


        HeapSortImpl<Character> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
                break;
            }
        }
        assertTrue(result);
        assertEquals('a', (char) a[0]);
        assertEquals('y', (char) a[a.length-1]);

    }

    @Test
    public void testHeapSortLarge() {
        System.out.println("heapSortLarge");
        Integer[] a = new Integer[1000000];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000000);
        }

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }
}
