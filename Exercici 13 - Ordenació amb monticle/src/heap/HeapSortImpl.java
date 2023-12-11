
package heap;

/**
 * Clase que contiene un método que implementa el algoritmo de ordenación
 * HeapSort haciendo uso de un heap.
 * @author Carlos Gálvez & Unai Pueyo
 */
public class HeapSortImpl<E extends Comparable<E>> implements HeapSort<E> {

    /**
     * {@inheritDoc}
     * <li><b>Precondición:</b>
     * <pre>
     *     P ≡ { h != null }
     * </pre>
     * </li>
     * <li><b>Poscondición:</b>
     * <pre>
     *     Q ≡ { ∀i: 0 <= i < h.length - 1: h[i].compareTo(h[i+1]) <= 0 }
     * </pre>
     * </li>
     *
     * </li>
     * <li><b>Orden de complejidad:</b>
     * <ul>
     *  <li>CPU: Sería O(n · log n) ya que el número de operaciones se delimita por la parte
     *           de la ordenación donde para cada elemento de h (n elementos) debemos situarlo
     *           en su lugar. Esta operación conlleva un tiempo O(log n) ya que va
     *           dividiendo/multiplicando el índice por 2. Y, por el teorema de la composición,
     *           su complejidad será O(n) * O(log n) = O(n · log n).
     *  </li>
     *  <li>Memoria: 0(1) ya que, al aplicar la optimización de utilizar una parte del array de
     *               entrada como heap, siempre tendremos que una parte del array ya se habrá
     *               ordenado y el resto faltará por ordenar. Como no utilizamos memoria extra
     *               que dependa del número de elementos de entrada, el uso de memoria es constante.
     *  </li>
     * </ul>
     * </li>
     */
    @Override
    public void heapSort(E[] h) {
        int n = h.length;

        // Construye un max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapConvert(h, n, i);
        }

        // Extrae elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Intercambia la raíz (el máximo) con el último elemento no ordenado
            E temp = h[0];
            h[0] = h[i];
            h[i] = temp;

            // Llama a heapify para reconstruir el heap en el subarray no ordenado
            heapConvert(h, i, 0);
        }
    }

    private void heapConvert(E[] array, int n, int i) {
        int largest = i;
        int leftNode = 2 * i + 1;
        int rightNode = 2 * i + 2;

        // Compara con el hijo izquierdo
        if (leftNode < n && array[leftNode].compareTo(array[largest]) > 0) {
            largest = leftNode;
        }

        // Compara con el hijo derecho
        if (rightNode < n && array[rightNode].compareTo(array[largest]) > 0) {
            largest = rightNode;
        }

        // Si el nodo raíz no es el más grande, intercámbialo con el más grande
        if (largest != i) {
            E swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Llama recursivamente a heapify en el subárbol afectado
            heapConvert(array, n, largest);
        }
    }
}
