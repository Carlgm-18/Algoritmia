package search;

/**
 * Esta clase agrupa cuatro métodos de búsqueda de elementos en una lista,
 * dos de ellos iterativos y dos recursivos.
 */
public class Search {
    private static int cont;

    /**
     * Método que encuntra la posición de un elemento dentro de un array
     * de manera lineal e iterativa y cuenta el número de comparaciones realizadas.
     * <br>
     * <li>Precondición: true</li>
     * <li>Poscondición: { (0 <= i <= list.length) ^ (list[i] == element) }</li>
     * <li>Orden de complejidad: O(n). En el peor de los casos, el elemento a encontar estará
     *                              al final de la lista y habrá que recorrer toda la lista</li>
     * @param list lista sobre la que buscar
     * @param element elemento a encontrar
     * @return índice del elemento
     * @param <E> tipo del elemento
     */

    public static <E extends Comparable<E>> int iterativeLinearSearch(E[] list, E element) {
        cont = 0;
        for (int i = 0; i < list.length; i++) {
            cont++;
            if(list[i].compareTo(element) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que encuntra la posición de un elemento dentro de un array
     * de manera lineal y recursiva y cuenta el número de comparaciones realizadas.
     * <br>
     * <li>Precondición: true</li>
     * <li>Poscondición: { (0 <= i <= list.length) ^ (list[i] == element) }</li>
     * <li>Orden de complejidad: O(n). En el peor de los casos, el elemento a encontar estará
     *                              al final de la lista y habrá que recorrer toda la lista</li>
     * @param list lista sobre la que buscar
     * @param element elemento a encontrar
     * @return índice del elemento
     * @param <E> tipo del elemento
     */
    public static <E extends Comparable<E>> int recursiveLinearSearch(E[] list, E element) {
        cont = 0;
        return recursiveLinearSearch(list, element, 0);
    }

    private static <E extends Comparable<E>> int recursiveLinearSearch(E[] list, E element, int startIndex) {
        if((startIndex >= list.length)) {
            return -1;
        }
        cont++;
        if(list[startIndex].compareTo(element) == 0) {
            return startIndex;
        }else{
            return recursiveLinearSearch(list, element, startIndex + 1);
        }
    }

    /**
     * Método que encuntra la posición de un elemento dentro de un array
     * de manera dicotómica e iterativa y cuenta el número de comparaciones realizadas.
     * <br>
     * <li>Precondición: La lista debe estar ordenada</li>
     * <li>Poscondición: { (0 <= i <= list.length) ^ (list[i] == element) }</li>
     * <li>Orden de complejidad: O(log(n)). En el peor de los casos, el elemento a encontar estará
     *              en uno de los extremos de la lista y habrá que ir dividiendo la lista
     *              hasta llegar al extremo</li>
     * @param list lista sobre la que buscar
     * @param element elemento a encontrar
     * @return índice del elemento
     * @param <E> tipo del elemento
     */
    public static <E extends Comparable<E>> int iterativeBinarySearch(E[] list, E element) {
        cont = 0;
        int low = 0;
        int high = list.length - 1;
        int index;

        while(low <= high){
            index = (high + low)/2;
            cont++;

            if(element.compareTo(list[index]) == 0){
                return index;
            }
            if(element.compareTo(list[index]) > 0){
                low = index + 1;

            }else{
                high = index - 1;
            }
        }
        return -1;
    }

    /**
     * Método que encuntra la posición de un elemento dentro de un array
     * de manera dicotómica y recursiva y cuenta el número de comparaciones realizadas.
     * <br>
     * <li>Precondición: La lista debe estar ordenada</li>
     * <li>Poscondición: { (0 <= i <= list.length) ^ (list[i] == element) }</li>
     * <li>Orden de complejidad: O(log(n)). En el peor de los casos, el elemento a encontar estará
     *              en uno de los extremos de la lista y habrá que ir dividiendo la lista
     *              hasta llegar al extremo</li>
     * @param list lista sobre la que buscar
     * @param element elemento a encontrar
     * @return índice del elemento
     * @param <E> tipo del elemento
     */
    public static <E extends Comparable<E>> int recursiveBinarySearch(E[] list, E element) {
        cont = 0;
        return recursiveBinarySearch(list, element, 0, list.length - 1);
    }

    private static <E extends Comparable<E>> int recursiveBinarySearch(E[] list, E element, int start, int end) {
        if(start > end) return -1;

        int index = (start + end)/2;
        cont++;
        if(element.compareTo(list[index]) == 0) return index;

        if(element.compareTo(list[index]) > 0) {
            return recursiveBinarySearch(list, element, index + 1, end);
        } else {
            return recursiveBinarySearch(list, element, start, index - 1);
        }
    }

    /**
     * Devuelve el número de comparaciones que se han realizado al ejecutar
     * un método en concreto. El valor se actualiza cada vez que se llama a
     * un método.
     * @return número de comparaciones
     */
    public static int getCont() {
        return cont;
    }
}
