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

    @Override
    public void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        if(h == 1){
            b.push(a.pop());
        }
    }

    @Override
    public void iteratiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        
    }
}
