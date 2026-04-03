package prog2.vista;
/**
 * Utilitzem aquesta classe per obtenir excepcions personalitzades
 * per a errors relacionats amb el càmping
 *
 * @author Alberto
 */
public class ExcepcioCamping extends RuntimeException {
    /**
     * Constructor de l'excepció.
     *
     * @param message Missatge descriptiu de l'error.
     */
    public ExcepcioCamping(String message) {
        super(message);
    }
}
