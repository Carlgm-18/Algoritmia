/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.Stack;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class HanoiImpl<E extends Comparable<E>> implements Hanoi<E> {

    /**
     * {@inheritDoc}
     * <li>
     *     <b>Precondición</b>:
     *     <pre>
     *         {
     *              (h >= 0) ^ (a != null) ^ (b != null) ^ (c != null) ^
     *              (a.isEmpty() == false) ^ (b.isEmpty() == true) ^ (c.isEmpty() == true) ^
     *              ∀i: 0<= i < a.size: a.peek(i).compareTo(a.peek(i+1)) < 0
     *         }
     *     </pre>
     * </li>
     *
     * <li>
     *     <b>Poscondición</b>:
     *     <pre>
     *         {
     *              (a.isEmpty() == true) ^ (b.isEmpty() == true) ^ (c.isEmpty() == false) ^
     *              ∀i: 0<= i < c.size: c.peek(i).compareTo(c.peek(i+1)) < 0
     *         }
     *     </pre>
     * </li>
     *
     * <li>
     *     <b>Orden de complejidad</b>: O(2^h), siendo h la altura de la torre.
     *     Es así ya que si imaginamos las llamadas recrusivas como los nodos de un
     *     árbol binario, entonces necesitamos recorrer todos sus nodos que, a cada
     *     nivel de la altura de la torre, se van duplicando.
     * </li>
     * <br>
     * <li>
     *     <b>Casos</b>: Encontramos dos casos evidentes. Cuando h es igual a 1, entonces
     *     el disco que haya en la torre A se moverá directamente a la torre C. Y en el caso
     *     de que h sea mayor que uno, moveremos una subtorre de altura h-1 a B, moveremos
     *     ficha que quede en A a C y moveremos la subtorre que quedaba a C de tal manera
     *     que quede encima de la ficha que habíamos colocado en C.
     * </li>
     * <br>
     * <li>
     *     <b>Proff</b>:
     *     Hemos comprobado que las llamadas al método cumplen la precondición y la poscondición.<br>
     *     Las llamadas recursivas cumplen con la precondición y poscondicion.<br>
     *     Existe un caso base que acaba con la recursividad en h = 1.<br>
     *     En cada recursión reducimos el tamaño de los datos.
     * </li>
     *
     */
    @Override
    public void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        if(h == 1){
            c.push(a.pop());
        } else {
            recursiuHanoi(h - 1, a, c, b);
            c.push(a.pop());
            recursiuHanoi(h - 1, b, a, c);
        }
    }

    @Override
    public void iteratiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {

    }
}
