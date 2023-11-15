package utils.reference;
import utils.OrderedList;
import utils.exceptions.EmptyListException;
import utils.exceptions.NotSuchElementException;

/**
 * Implementación de la lista ordenada mediante el uso de referencias
 * @param <E> tipo de dato que contiene la lista
 */
public class OrderedListReference<E extends Comparable<E>> implements OrderedList<E> {
    private Node<E> head;
    public OrderedListReference() {
        this.head = null;
    }

    /**
     *
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(n)</li>
     */
    @Override
    public void add(E t) {
        if(this.head == null) {
            this.head = new Node<>(t);
        } else {
            Node<E> aux = this.head, newNode = new Node<>(t);
            while(aux.getNext() != null) {
                if(aux.getNext().getValue().compareTo(t) < 0) {
                    newNode.setNext(aux.getNext());
                    break;
                }
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(1)</li>
     */
    @Override
    public void clear() {
        this.head = null;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(n)</li>
     */
    @Override
    public boolean contains(E t) {
        Node<E> aux = this.head;
        while(aux != null) {
            if(aux.getValue().equals(t)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(1)</li>
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(n)</li>
     *
     * @throws EmptyListException
     * @throws NotSuchElementException
     */
    @Override
    public void remove(E t) {
        if(this.isEmpty()) {
            throw new EmptyListException("La lista está vacía");
        }
        if (!this.contains(t)) {
            throw new NotSuchElementException("El elemento no está en la lista");
        }
        Node<E> prev = this.head;
        Node<E> match = this.head.getNext();

        while(!match.getValue().equals(t)) {
            prev = prev.getNext();
            match = match.getNext();
        }

        prev.setNext(match.getNext());

    }

    private class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
