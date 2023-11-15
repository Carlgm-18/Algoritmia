import matrix.Matrix;
import search.Search;

public class Main {
    public static void main(String[] args) {

        Matrix<Integer> m1 = new Matrix<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, 3);
        Matrix<Integer> m2 = new Matrix<>(new Integer[]{1, 0, 0, 0, 1, 0, 0, 0, 1}, 3, 2);
        
        var m3 = m1.product(m2);
        System.out.println("Se han realizado "+ m3.getCount() +" productos");
        System.out.println(m3.toString());

//        int[] pos = new int[4];
//        int[] conts = new int[4];
//        int e = 9;
//        pos[0] = Search.iterativeLinearSearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, e);
//        conts[0] = Search.getCont();
//        pos[1] = Search.recursiveLinearSearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, e);
//        conts[1] = Search.getCont();
//        pos[2] = Search.iterativeBinarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, e);
//        conts[2] = Search.getCont();
//        pos[3] = Search.recursiveBinarySearch(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, e);
//        conts[3] = Search.getCont();
//
//        for (int i = 0; i < 4; i++) {
//            System.out.printf("Index: %d, Cont: %d\n", pos[i], conts[i]);
//        }
    }
}