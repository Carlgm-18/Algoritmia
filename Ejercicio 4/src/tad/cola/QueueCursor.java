package tad.cola;

/**
 * Implementación de una cola mediante el uso de arrays estáticos
 * accediendo a las posiciones utilizando la operación de módulo {@code %}
 * @param <T> tipo de elementos de la cola
 */
public class QueueCursor<T> implements Queue<T> {
    private final T[] data;
    private final int size;
    private int first, last;

    public QueueCursor(int size) {
        this.data = (T[]) new Object[size];
        this.first = this.last = 0;
        this.size = data.length;
    }
    @Override
    public void enqueue(T elem) {
        if(this.size() == this.size) {
            throw new ColaException("La cola está llena");
        }
        this.data[this.last%this.size] = elem;
        this.last++;
    }

    @Override
    public T dequeue() {
        if(this.first == this.last) {
            throw new ColaException("La cola está vacía");
        }
        this.first++;
        return data[(this.first-1)%this.size];
    }

    @Override
    public T first() {
        return this.data[this.first];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return last - first;
    }
}
