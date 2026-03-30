package prog2.model;

import java.io.Serializable;

public class CamiAsfalt extends AccesAsfalt implements Serializable {
    // Constructor amb estat donat
    public CamiAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, estat, metresQuadratsAsfalt);
    }

    // Constructor sense estat donat
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
