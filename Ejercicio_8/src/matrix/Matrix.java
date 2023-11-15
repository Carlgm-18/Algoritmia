package matrix;

import java.util.Arrays;

/**
 * Clase que representa una matriz mediante un array unidimiensional
 * aplicando el criterio de Row-major order.
 */
public class Matrix <T extends Number> {

    private T[] data;
    private final int nRows;
    private final int nColums;
    private int count;
    
    /**
     * Inicializa una instancia de la clase Matriz dados unos valores
     * @param data valores de la matriz
     * @param rows número de filas de la matriz
     * @param colums número de columnas de la matriz
     */
    public Matrix(T[] data, int rows, int colums) {
        this.nRows = rows;
        this.nColums = colums;

        if(data.length != rows*colums) {
            this.data = Arrays.copyOf(data, rows*colums);
        }else{
            this.data = data;
        }
    }

    /**
     * Inicializa una matriz vacía
     * @param rows número de filas de la matriz
     * @param colums número de columnas de la matriz
     */
    public Matrix(int rows, int colums) {
        this.data = (T[]) new Number[rows*colums];
        this.nColums = colums;
        this.nRows = rows;
    }

    /**
     * Calcula la multiplicación de dos matrices y cuenta
     * el número de productos que se calculan. El conteo se guarda
     * en el atributo {@code count}.
     * <br>
     * <li>Precondición: El número de filas de la primera matrix debe ser igual
     *                  al número de columnas de la segunda.</li>
     * <li>Poscondición: AxB (donde <b>x</b> hace referencia al operador de
     *                        producto de matrices).</li>
     * <li>Orden de complejidad: O(m*n<sup>2</sup>) donde m es el número de filas de la segunda matriz y
     *                           n es su número de columnas.</li>
     * <pre>    Por ejemplo si multiplicamos una matriz 3x2 con otra
     *   2x3, se ejecutan 18 productos 18 = 2 · 3^2.</pre>
     * @param m matriz con la cual se multiplica
     * @return nueva matriz que representa el producto de las dos anteriores
     */

    public Matrix<T> product(Matrix<T> m) throws IncompatibleDimensionsException{
        if(this.nColums != m.nRows) {
            throw new IncompatibleDimensionsException("El número de columnas de la primera matriz debe +"+
                                                        "coincidir con el número de filas de la segunda.");
        }

        Matrix<T> ret = new Matrix<>(this.nRows, m.nColums);
        ret.count = 0;
        double acc;

        for (int i = 0; i < ret.nRows; i++) {
            for (int j = 0; j < ret.nColums; j++) {
                acc = 0.0;
                for(int k = 0; k < nColums; k++) {
                    acc += this.getValue(i, k).doubleValue() * m.getValue(k, j).doubleValue();
                    ret.count++;
                }
                ret.setValue((T) Double.valueOf(acc), i, j);
            }
        }
        return ret;
    }

    /**
     * Devuelve el elemento de una matriz dada su posición
     * @param row fila de la matriz
     * @param column columna de la matriz
     * @return el valor en la posición
     */
    public T getValue(int row, int column) {
        if(row * this.nColums + column >= nColums*nRows || nColums*nRows < 0) {
            throw new InexistentPositionException("La matriz no cuenta con la posición ("+ row +","+ column +")");
        }
        return data[row * this.nColums + column];
    }

    /**
     * Fija el elemento de una matriz dada su posición y un valor
     * @param row fila de la matriz
     * @param column columna de la matriz
     * @param value valor a fijar
     */
    public void setValue(T value, int row, int column) {
        if(row * this.nColums + column >= nColums*nRows || nColums*nRows < 0) {
            throw new InexistentPositionException("La matriz no cuenta con la posición ("+ row +","+ column +")");
        }
        data[row * this.nColums + column] = value;
    }
    
    public int getCount() {
        return this.count;
    }

    public int getnRows() {
        return nRows;
    }

    public int getnColums() {
        return nColums;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
