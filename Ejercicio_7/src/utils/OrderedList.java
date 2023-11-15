package utils;

/**
 * Implementación de la clase abstracta Lista ordenada genñerica donde,
 * los elementos que se añaden, se ordenan automáticamente.
 * @param <E> tipo de dato que se guardará en la lista
 */
public interface OrderedList<E extends Comparable<E>> {
    /**
     * Permite añadir un elemento a la lista.
     * <br>
     * <li>Precondición: La lista debe estar ordenada.</li>
     * <li>Postcondición: La lista debe contener el elemento añadido.</li>
     *
     * @param e elemento para añadir
     */
    void add(E e);

    /**
     * Vacía la lista.
     * <br>
     * <li>Precondición: El argumento debe ser una lista.</li>
     * <li>Postcondición: La lista debe estar vacía.</li>
     */
    void clear();

    /**
     * Comprueba si el elemento dado se encuentra en la lista.
     * <br>
     * <li>Precondición: La lista debe estar ordenada.</li>
     * <li>Postcondición: Debe devolver true si el elemento está en la lista
     *                    y false si no lo está.
     * </li>
     * @param e elemento a buscar
     * @return si el elemento se encuentra en la lista
     */
    boolean contains(E e);

    /**
     * Compueba si la lista está vacía.
     * <br>
     * <li>Precondición: El argumento debe ser una lista.</li>
     * <li>Postcondición: Devuelve true si la lista está vacía,
     *                    y false si no lo está.
     * </li>
     *
     * @return si la lista está vacía
     */
    boolean isEmpty();

    /**
     * Elimina un elemento de la lista.
     * <br>
     * <li>Precondición: La lista debe contener algún elelemnto</li>
     * <li>Postcondición: El elemento no puede estar en la lista</li>
     *
     * @param e elemento a eliminar
     */
    void remove(E e);
}
