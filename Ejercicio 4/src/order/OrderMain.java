package order;

import order.utils.Sorter;

import java.util.Arrays;

public class OrderMain {
    public static void main(String[] args) {

        Integer[] list = {7, 6, 31, 5, 4, 3, 2, 1};

        Sorter<Integer> sorter = new Sorter<>();

        sorter.sortComparable(list);

        //sorter.sortComparator(list);

        System.out.println(Arrays.toString(list));
    }
}