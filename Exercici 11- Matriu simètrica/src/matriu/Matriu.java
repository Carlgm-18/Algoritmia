
package matriu;

/**
 * Interfície que respresenta una matriu que pot emmagatzemar elements 
 * comparables
 * @author Carlos Gálvez & Unai Pueyo
 * @param <E> element que emmagatzema la matriu
 */
public interface Matriu <E extends Comparable<E>>{
    
    /**
     * Set d'un element a la matriu
     * <li><b>Precondición: </b> {row >= 0 ^ col >= 0}</li>
     * @param e element a insertar
     * @param row fila
     * @param col columna
     */
    void set(E e, int row,int col);
    
    /**
     * Retorna element d'una posició
     * <li><b>Precondición: </b> {row >= 0 ^ col >= 0}</li>
     * @param row fila
     * @param col columna
     * @return element de la fila i columna
     */
    E get(int row, int col);
    
    /**
     * Indica si la matriu és simètrica. Algorisme recursiu
     * <li><b>Precondición: </b> true</li>
     * <li><b>Postcondición: </b> true</li>
     *
     * <li><b>Orden de complejidad:</b> Siendo n el número de celdas ->
     *      O(isSymmetricalRecursiu()) = O(n^2). Recorre todas las celdas de la matriz.</li>
     *
     * <li><b>Análisis de casos: </b>
     *      Encontramos dos casos diferenciados:<br>
     *      <li># filas/columnas = 1:
     *          la matriz es simétrica al ser un solo elemento
     *      </li>
     *      <li># filas/columnas > 1:
     *                comrobaremos los límites de la submatriz para saber si son traspuestos.
     *                Si no lo son, la matriz no es simétrica.
     *      </li>
     * </li>
     * Hemos seguido todos los pasos para comprobar los proofs.
     * @return vertader si és simètrica, false en cas contrari
     */
    boolean isSymmetricalRecursiu();
    
    /**
     * Indica si la matriu és simètrica. Algorisme iteratiu
     * <li><b>Precondición: </b> true</li>
     * <li><b>Postcondición: </b> true</li>
     *
     * <li><b>Orden de complejidad:</b> Siendo n el número de celdas ->
     *      O(isSymmetricalRecursiu()) = O(n^2). Recorre todas las celdas de la matriz.
     *      Como en cada recursión hacemos dos llamadas recursivas, podemos imaginarlo como un
     *      árbol binario donde cada nodo hijo representa la submatriz a comprobar.
     *      Como en cada nodo recorremos la matriz al completo tenemos n^2</li>
     *
     * <li><b>Análisis de casos: </b>
     *      Encontramos dos casos diferenciados:<br>
     *      <li># filas/columnas = 1:
     *          la matriz es simétrica al ser un solo elemento
     *      </li>
     *      <li># filas/columnas > 1:
     *                comrobaremos los límites de la submatriz para saber si son traspuestos.
     *                Si no lo son, la matriz no es simétrica.
     *      </li>
     * </li>
     * Hemos seguido todos los pasos para comprobar los proofs.
     * @return vertader si és simètrica, false en cas contrari
     */
    boolean isSymmetricalIteratiu();
}
