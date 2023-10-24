import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearcherTest {
    private BinarySearcher binarySearcher;
    private final boolean[] solutions = {false, true, true, true, true, false};
    private static final int[] initialValues = {0, 0, 0, -1, -5};
    private final Integer[][] indexes = {
            {-1, 0, 5, 8, 9, 15},          //[0,10)
            {-1, 0, 50, 75, 99, 150},      //[0, 99]
            {-1, 0, 500, 750, 999, 1050},  //[0, 999]
            {-2, -1, 50, 75, 98, 150},     //[-1, 98]
            {-10, -5, 0, 2, 4, 10}         //[-5, 4]
    };
    private static final Integer[][] sortedData = {
            new Integer[10],      //Short sorted array
            new Integer[100],     //Med sorted array
            new Integer[1000],    //Long sorted array
            new Integer[100],     //Med shifted array
            new Integer[10]       //Short shifted array
    };

    @BeforeAll
    static void beforeAll() {
        //Fill data
        for (int i = 0; i < sortedData.length; i++)
            for (int j = 0, k = initialValues[i]; j < sortedData[i].length; j++, k++) sortedData[i][j] = k;
    }

    @BeforeEach
    void setUp() {
        binarySearcher = new BinarySearcher();
    }

    @Test
    void binarySearchComparable() {
        for (int i = 0; i < sortedData.length - 1; i++) {
            for (int j = 0; j < indexes[i].length - 1; j++) {
                int result = binarySearcher.binarySearch(sortedData[i], indexes[i][j]);
                Assertions.assertEquals(solutions[j], result != -1);
            }
        }
    }

    @Test
    void binarySearchComparator() {
        for (int i = 0; i < sortedData.length - 1; i++) {
            for (int j = 0; j < indexes[i].length - 1; j++) {
                int result = binarySearcher.binarySearch(sortedData[i], indexes[i][j], Integer::compare);
                Assertions.assertEquals(solutions[j], result != -1);
            }
        }
    }
}