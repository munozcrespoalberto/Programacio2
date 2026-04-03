package prog2.model;

import java.io.Serializable;
/**
 * Classe que representa un camí de terra.
 * Els camins de terra NO permeten l'accés amb vehicle.
 *
 * @author Alberto
 */

public class CamiTerra extends AccesTerra implements Serializable {
    // Constructor amb estat donat
    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
    }

    // Constructor sense estat donat
    public CamiTerra(String nom, float longitud) {
        super(nom, longitud);
    }

    // Sempre camins donen false
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipus: Camí de terra";
    }
}
