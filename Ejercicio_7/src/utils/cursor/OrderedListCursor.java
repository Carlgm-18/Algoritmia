package utils.cursor;
import utils.OrderedList;
import utils.exceptions.EmptyListException;
import utils.exceptions.FullListException;
import utils.exceptions.NotSuchElementException;

import java.util.Arrays;

/**
 * Implememtación de la lista ordenada mediante el uso de arrays.
 * @param <E> tipo de dato que se va a almacenar
 */
public class OrderedListCursor<E extends Comparable<E>> implements OrderedList<E> {

    private final E[] data;
    private int size;
    public OrderedListCursor(int size) {
        this.data = (E[]) new Object[size];
        this.size = 0;
    }

    /**
     *
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(n)</li>
     *
     * @throws FullListException
     */
    @Override
    public void add(E t) throws FullListException {
        if(this.size == this.data.length) {
            throw new FullListException("La lista está llena");
        }
        int addIndex = this.size;
        boolean found = false;
        for (int i = 1; (i < this.size) && !found; i++) {
            if(t.compareTo(this.data[i]) < 0) {
                addIndex = i;
                found = true;
            }
        }
        for (int i = this.size; i > addIndex; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[addIndex] = t;
        this.size++;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(1)</li>
     */
    @Override
    public void clear() {
        this.size = 0;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(log n)</li>
     */
    @Override
    public boolean contains(E t) {
        return this.binarySearch(t) >= 0;
    }

    /**
     * {@inheritDoc}
     *
     * <li>Orden de complejidad: O(1)</li>
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
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
    public void remove(E t) throws EmptyListException, NotSuchElementException {
        if(this.isEmpty()) {
            throw new EmptyListException("La lista está vacía");
        }
        if (!this.contains(t)) {
            throw new NotSuchElementException("El elemento no está en la lista");
        }

        int retIndex = this.binarySearch(t);
        for (int i = retIndex + 1; i < this.size; i++) {
            this.data[i-1] = this.data[i];
        }
        this.size--;
    }


    private int binarySearch(E e) {
        int low = 0;
        int high = this.size - 1;
        int index;
        while(low <= high){
            index = (high + low)/2;
            if(e.compareTo(this.data[index]) == 0){
                return index;
            }
            if(e.compareTo(this.data[index]) > 0){
                low = index + 1;
            }else{
                high = index - 1;
            }
        }
        return -1;
    }
}
