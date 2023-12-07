
package backtracking;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe implementació Backtracking
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class BacktrackingImpl implements Backtracking {

    /**
     * {@inheritDoc}
     * <li>
     *     <b>Precondición:</b><pre> P ≡ { M >= 0 ^ a != null ^ (∀i: 0 <= i < a.length: a[i] > 0)}</pre>
     * </li>
     * <li>
     *     <b>Poscondición:</b><pre> Q ≡ { ∀i: 0 <= i < ret.length(): (∑(j = 0, a.get(i).length(), a.get(i).get(j))) ^
     *      ∀j: 0 <= j < a.get(i).length(): Arrays.binarySearch(a, a.get(i).get(j)) >= 0}</pre>
     * </li>
     * <li>
     *     <b>Complejidad:</b> El orden de complejidad de este algoritmo es O(2^n) siendo n el número
     *                          de elementos de a. Vamos a tener que hacer las diferentes variaciones
     *                          de los posibles valores. Podemos relacionar esta complejidad a la
     *                          estructura de un árbol binario viendo que, para cada elemento, debe
     *                          decidir si inlcluirlo o no. Como la altura del árbol es n, el número
     *                          de nodos del árbol es 2^n. Va a tener que recorrer todo el árbol
     *                          con algunas excepciones.
     * </li>
     * <br>
     * <li>
     *     <b>Análisis de casos:</b> Podemos encontrar dos casos claros: que target sea 0, quiere decir que
     *                               ya hemos encontrado los valores necesarios y, si no, probamos con
     *                               un valor extra.
     * </li>
     * <br>
     *<li>
     *    <b>Proofs:</b><pre> Todos los proofs han sido comprobaso. El código es correcto y cumple con
     *                        las precondiciones y poscondiciones además de dejar de ejecutarse al
     *                        llegar al caso base.
     *</li>
     */
    @Override
    public ArrayList<ArrayList<Integer>> sumM(int[] a, int M) {
        var set = new ArrayList<ArrayList<Integer>>();
        sumM(a, 0, M, new ArrayList<>(), set);
        set.sort(Comparator.comparingInt(ArrayList::size));
        return set;
    }

    private static void sumM(int[] nums, int start, int target, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            // Se encontró un subconjunto que suma el objetivo
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Agrega el número actual al subconjunto parcial
            current.add(nums[i]);

            // Llamada recursiva con el número actual añadido
            sumM(nums, i + 1, target - nums[i], current, result);

            // Retrocede (backtrack) para probar otras combinaciones
            current.remove(current.size() - 1);
        }
    }
}
