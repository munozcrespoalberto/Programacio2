package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que representa un accés de terra.
 * Conté la longitud en metres.
 *
 * @author Alberto
 */
public abstract class AccesTerra extends Acces implements Serializable {
    float longitud;

    /**
     * Constructor amb estat donat.
     *
     * @param nom       Nom de l'accés.
     * @param estat     Estat de l'accés (obert/tancat).
     * @param longitud  Longitud en metres.
     */
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Constructor per defecte obert.
     *
     * @param nom       Nom de l'accés.
     * @param longitud  Longitud en metres.
     */
    public AccesTerra(String nom, float longitud) {
        super(nom);
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString() + ", longitud: " + longitud + " metres";
    }
}
