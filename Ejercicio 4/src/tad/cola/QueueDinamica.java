package tad.cola;
/**
 * Implementación de una cola mediante el uso de referencias a traves de la clase {@link Nodo}
 * @param <T> tipo de elementos de la cola
 */
public class QueueDinamica<T> implements Queue<T> {

    private Nodo<T> first, last;
    private int size;

    public QueueDinamica() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    @Override
    public void enqueue(T elem) {
        Nodo<T> newNode = new Nodo<>(elem);

        if(this.isEmpty()) {
            this.first = newNode;
        }else{
            newNode.setBefore(this.last);
        }
        this.last = newNode;
        this.size++;
    }

    @Override
    public T dequeue() {
        if(this.size == 0) {
            throw new ColaException("La cola está vacía");
        }

        T ret = this.first.getValue();

        this.first = this.first.getNext();

        return ret;
    }

    @Override
    public T first() {
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private static class Nodo<T> {
        private Nodo<T> before, next;
        private final T value;

        public Nodo(T elem) {
            this.before = null;
            this.next = null;
            this.value = elem;
        }

        public T getValue() {
            return this.value;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }

        public Nodo<T> getNext() {
            return this.next;
        }

        public void setBefore(Nodo<T> before) {
            this.before = before;
        }

        public Nodo<T> getBefore() {
            return this.before;
        }
    }
}
