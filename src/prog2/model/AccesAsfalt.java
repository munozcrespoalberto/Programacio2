package prog2.model;

import java.io.Serializable;

/**
 * Classe abstracta que representa un accés asfaltat.
 * Conté els metres quadrats d'asfalt.
 *
 * @author Alberto
 */
public abstract class AccesAsfalt extends Acces implements Serializable {
    private float metresQuadratsAsfalt;

    /**
     * Constructor amb estat donat.
     *
     * @param nom               Nom de l'accés.
     * @param estat             Estat de l'accés (obert/tancat).
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     */
    public AccesAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    /**
     * Constructor sense estat (per defecte obert).
     *
     * @param nom               Nom de l'accés.
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     */
    public AccesAsfalt(String nom, float metresQuadratsAsfalt) {
        super(nom);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    public float getMetresQuadratsAsfalt() {
        return metresQuadratsAsfalt;
    }

    public void setMetresQuadratsAsfalt(float metresQuadratsAsfalt) {
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    // L'implementem a les seves subclasses
    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString() + ", metres Quadrats d'asfalt: " + metresQuadratsAsfalt + " metres quadrats";
    }
}
