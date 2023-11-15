package peak;

import java.awt.Point;

/**
 * Implementation of the interface {@link Peak} that
 * defines the {@code peak()} method.
 * @author Carlos Gálvez, Unai Pueyo
 */
public class PeakImpl implements Peak {

    
    /**
     * Find the maximun value from an integer list
     * 
     * <li>Precondición:
     *      <pre>
     *           { ∃i: 0 <= i < a.length:
     *             (
     *               (∀j: 0 <= j < i: a[j] < a[j+1])
     *             ^ (∀j: i <= j < a.length-1: a[j] > a[j+1]
     *              )
     *            }
     *      </pre>
     *  </li>
     *
     * <li>Poscondición:
     *      <pre>
     *          { p ∈ Point;
     *            ∀i: (0 <= i < a.length) ^ (i != p.y): p.x > a[i]
     *           }
     *      </pre>
     * </li>
     *
     * <li>Orden de complejidad: O(peak()) = O(log n) =
     *      a·log(b·n) + c <br><br>
     *      El orden de complejidad tiende a ser logarítmico ya que para
     *      cada iteración del bucle del algoritmo, dividimos en dos la
     *      cantidad de elementos a comprobar.
     * </li>
     * @param a target list
     * @return max value of the list
     */
    @Override
    public Point peak(int[] a) {
        int low = 1;
        int high = a.length - 2;

        int max = (low + high) >>> 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
                max = mid;
                break;
            }

            if (a[mid] < a[mid-1]) high = mid-1;
            if (a[mid] < a[mid+1]) low = mid+1;
        }
        return new Point(a[max], max);
    }

}
