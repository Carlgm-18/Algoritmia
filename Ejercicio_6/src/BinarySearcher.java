import java.util.Comparator;

/**
 * Esta clase agrupa dos métodos de busqueda que implementan el
 * algoritmo de búsqueda dicotómica.
 *
 * @author Carlos Gálvez, Unai Pueyo
 */
public class BinarySearcher {
    /**
     * Método que busca un elemento en una lista de objetos que implementan la
     * interfaz comparable y devuelve su posición.
     * <br><br>
     * Pre ≡ La lista de objetos debe estar ordenada.
     * <br><br>
     * return ∈ int <br>
     * Pos ≡ { 0 <= return <= list.length}
     *
     * @param list lista de objetos sobre la que se quiere buscar
     * @param e elemento a buscar
     * @return posición del elemento
     * @param <T> tipo de dato del objeto a buscar
     */
    public <T extends Comparable<T>> int binarySearch(T[] list, T e) {
        int low = 0;
        int high = list.length - 1;
        int index;
        while(low <= high){
            index = (high + low)/2;
            if(e.compareTo(list[index]) == 0){
                return index;
            }
            if(e.compareTo(list[index]) > 0){
                low = index + 1;
            }else{
                high = index - 1;
            }
        }

        return -1;
    }

    /**
     * Método que busca un elemento en una lista de objetos y devuelve su posición.
     * <br><br>
     * Pre ≡ La lista de objetos debe estar ordenada.
     * <br><br>
     * return ∈ int <br>
     * Pos ≡ { 0 <= return <= list.length}
     *
     * @param list lista de objetos sobre la que se quiere buscar
     * @param e elemento a buscar
     * @param comparator objeto que compara dos elementos
     * @return posición del elemento
     * @param <T> tipo de dato del objeto a buscar
     */
    public <T> int binarySearch(T[] list, T e, Comparator<T> comparator) {
        int low = 0;
        int high = list.length - 1;
        int index;
        while(low <= high){
            index = (low + high)/2;
            if(comparator.compare(e, list[index]) == 0){
                return index;
            }
            if(comparator.compare(e, list[index]) > 0){
                low = index + 1;
            }else{
                high = index - 1;
            }
        }

        return -1;
    }
}
