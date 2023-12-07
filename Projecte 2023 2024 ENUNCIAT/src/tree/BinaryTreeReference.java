
package tree;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 */
public class BinaryTreeReference<E extends Comparable<E>> implements BinaryTree<E> {
    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private final T value;

        public Node(T value){
            this.value = value;
        }
    }

    private Node<E> root;

    /**
     * Constructor de la clase que crea una instancia del un árbol vacío.
     */
    public BinaryTreeReference() {
        root = null;
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *      O(isEmpty()) = O(1). Es un cálculo directo.</li>
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *      O(insert()) = O(log n). Recorre el árbol por rama cuya
     *          mayor longitud equivale a la altura del árbol.</li>
     */
    @Override
    public void insert(E e) {
        root = insertRecursive(root, e);
    }

    private Node<E> insertRecursive(Node<E> r, E e) {
        if(r == null) return new Node<>(e);
        if(e.compareTo(r.value) < 0) {
            r.left = insertRecursive(r.left, e);
        } else if (e.compareTo(r.value) > 0) {
            r.right = insertRecursive(r.right, e);
        }
        return r;
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *      O(contains()) = O(n). Recorre el árbol por rama cuya
     *          mayor longitud equivale a la altura del árbol. Recorre todos los nodos</li>
     */
    @Override
    public boolean contains(E e) {
        return containsRecursive(root, e);
    }

    private boolean containsRecursive(Node<E> r, E e) {
        if(r == null) return false;
        if(r.value.compareTo(e) == 0) return true;

        return containsRecursive(r.left, e) || containsRecursive(r.right, e);
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *      O(longestBranch()) = O(n). Recorre el árbol por rama cuya
     *          mayor longitud equivale a la altura del árbol. Recorre todos los nodos</li>
     */
    @Override
    public int longestBranch() {
        return countNode(root) - 1;
    }

    private int countNode(Node<E> r) {
        if(r == null) return 0;
        return Math.max(countNode(r.left), countNode(r.right)) + 1;
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *      O(getRoot()) = O(n). Recorre el árbol por rama cuya
     *          mayor longitud equivale a la altura del árbol. Recorre todos los nodos</li>
     */
    @Override
    public E getMother(E e) {
        return getMotherRecursive(root, e);
    }

    private E getMotherRecursive(Node<E> r, E e) {
        if(r == null) return null;

        if(r.left != null && r.left.value.equals(e)) return r.value;

        if(r.right != null && r.right.value.equals(e)) return r.value;

        var leftR = getMotherRecursive(r.left, e);
        var rightR = getMotherRecursive(r.right, e);

        return leftR != null ? leftR : rightR;
    }

    /**
     * {@inheritDoc}
     * <li>Orden de complejidad: Siendo n el número de nodos ->
     *     O(getRoot()) = O(1). Es un cálculo directo.</li>
     */
    @Override
    public E getRoot() {
        return root.value;
    }
}
