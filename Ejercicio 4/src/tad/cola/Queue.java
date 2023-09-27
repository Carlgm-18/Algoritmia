package tad.cola;

/**
 * Interfaz que encapsua las funcionalidades de una cola.
 * Una cola es una estructura de datos abstracta que se
 * basa en el principio FIFO
 *
 * @param <T> elemento que va a contener la cola
 */
public interface Queue<T> {

    /**
     * Añade un elemento al final de la cola
     * @param elem elemento a encolar
     */
    void enqueue(T elem);

    /**
     * Desencola en primer elemento de la cola
     * eliminándolo
     * @return elemento desencolado
     */
    T dequeue();

    /**
     * Devuelve el primer elemento de la cola
     * sin eliminarlo
     * @return primer elemento
     */
    T first();


    /**
     * Compruba si la cola está vacía
     * @return la cola está vacía
     */
    boolean isEmpty();

    /**
     * Contabiliza el número de elementos presentes en la cola
     * @return número de elementos
     */
    int size();

}
