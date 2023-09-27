package tad.cola;

/**
 * Encargada de contener las diferentes excepciones que
 * puede generar la cola
 */
public class ColaException extends RuntimeException {
    public ColaException(String msg) {
        super(msg);
    }
}
