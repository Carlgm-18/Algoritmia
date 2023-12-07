/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriu;

/**
 *
 * @author Carlos Gálvez & Unai Pueyo
 * @param <E>
 */
public class MatriuImpl<E extends Comparable<E>> implements Matriu<E> {
    private final int cols;
    private int rows;
    private final E[] data;

    /**
     * Es crea una matriu representada en un array per files
     * <li><b>Precondición: </b> {rows > 0 ^ cols > 0}</li>
     * @param cols numero de columnas de la matriz
     * @param rows numero de filas de la matriz
     */
    public MatriuImpl(int rows, int cols) {
        data = (E[]) new Comparable[rows*cols];
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Es crea una matriu representada en un array per files
     * <li><b>Precondición: </b> {rows > 0 ^ cols > 0 ^ matriu.length == rows*cols}</li>
     * @param matriu array de datos
     * @param cols numero de columnas de la matriz
     * @param rows numero de filas de la matriz
     */
    public MatriuImpl(E[] matriu, int rows, int cols) {
        this.data = matriu;
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void set(E e, int row, int col) {
        data[row * this.cols + col] = e;
    }

    @Override
    public E get(int row, int col) {
        return data[row * this.cols + col];
    }


    @Override
    public boolean isSymmetricalRecursiu() {
        // Si la matriz no es cuadrada, no es simétrica
        if(rows != cols) return false;
        return isSymmetricalRecursive(0, 0);
    }

    private boolean isSymmetricalRecursive(int row, int col) {

        //Si pasmos por toda la matriz, es simétrica
        if (row == this.rows) {
            return true;
        }

        //Si dos elementos simétricos son diferentes, no es simétrica
        if (!get(row, col).equals(get(col, row))) {
            return false;
        }

        //Si llegamo a la última columna
        if (col == this.cols - 1) {
            // Pasamos a la siguiente fila
            return isSymmetricalRecursive(row + 1, 0);
        } else {
            // Pasamos al siguiente elemento de la fila
            return isSymmetricalRecursive(row, col + 1);
        }
    }

    @Override
    public boolean isSymmetricalIteratiu() {
        // Si la matriz no es cuadrada, no es simétrica
        if(rows != cols) return false;

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col <= row; col++) {

                // Si algún par de elementos simétricos no concuerda,
                // la matriz no es simétrica
                if (!get(row, col).equals(get(col, row))) {
                    return false;
                }
            }
        }

        // Si no detectamos pares discordantes,
        // la matriz es simétrica
        return true;
    }
}
