package order.utils;

import java.util.Comparator;

/**
 * Esta clase tiene la función de ser capaz de ordenar una lista de elementos genéricos.
 *
 * Para ordenar los elementos la clase hace uso del algoritmo de selección directa.
 *
 * El algortimo de selección directa recorre una lista de elementos de tal manera
 * que busca el menor de los elementos y lo coloca en la primera posición; luego busca
 * el segundo elemento más pequeño y lo coloca en la segunda posición y así hasta
 * que la lista esté completamente ordenada.
 *
 * @param <T> tipo de elemento a ordenar
 */
public class Sorter<T extends Comparable<T>>{

    private final Comparator<T> comparator;

    public Sorter() {
        comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    /**
     * Implementa la ordenación de elementos que tengan
     * implementada la interfaz {@link Comparable}
     *
     * @param data lista de elementos a ordenar
     */
    public void sortComparable(T[] data) {
        T temp;
        int min;
        for(int i = 0; i < data.length - 1; i++) {
            min = i;
            for(int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[min]) < 0) {
                    min = j;
                }
            }
            if(data[min].compareTo(data[i]) < 0) {
                temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
    }

    /**
     * Implementa la ordenación de elementos
     * utilizando un objeto de tipo {@link Comparator}
     * @param data lista de elementos a ordenar
     */
    public void sortComparator(T[] data) {

        T temp;
        int min;
        for(int i = 0; i < data.length - 1; i++) {
            min = i;
            for(int j = i; j < data.length; j++) {
                if (comparator.compare(data[j], data[min]) < 0) {
                    min = j;
                }
            }
            if(comparator.compare(data[min], data[i]) < 0) {
                temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
    }
}
