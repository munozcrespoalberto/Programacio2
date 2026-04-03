package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa un camí asfaltat.
 * Els camins asfaltats NO permeten l'accés amb vehicle.
 *
 * @author Alberto
 */
public class CamiAsfalt extends AccesAsfalt implements Serializable {
    /**
     * Constructor amb estat donat.
     *
     * @param nom               Nom del camí.
     * @param estat             Estat (obert/tancat).
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     */
    public CamiAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, estat, metresQuadratsAsfalt);
    }

    /**
     * Constructor per defecte obert.
     *
     * @param nom               Nom del camí.
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     */
    public CamiAsfalt(String nom, float metresQuadratsAsfalt) {
        super(nom, metresQuadratsAsfalt);
    }

    // Sempre camins donen false
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipus: Camí asfaltat";
    }
}
