package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una carretera asfaltada.
 * Les carreteres asfaltades SÍ permeten l'accés amb vehicle i tenen un pes màxim.
 *
 * @author Alberto
 */
public class CarreteraAsfalt extends AccesAsfalt implements Serializable {
    int pesMaxim;

    /**
     * Constructor amb estat donat.
     *
     * @param nom               Nom de la carretera.
     * @param estat             Estat (obert/tancat).
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     * @param pesMaxim          Pes màxim permès en kg.
     */
    public CarreteraAsfalt(String nom, boolean estat, float metresQuadratsAsfalt, int pesMaxim) {
        super(nom, estat, metresQuadratsAsfalt);
        this.pesMaxim = pesMaxim;
    }

    /**
     * Constructor sense estat (per defecte obert).
     *
     * @param nom               Nom de la carretera.
     * @param metresQuadratsAsfalt Metres quadrats d'asfalt.
     * @param pesMaxim          Pes màxim permès en kg.
     */
    public CarreteraAsfalt(String nom, float metresQuadratsAsfalt, int pesMaxim) {
        super(nom, metresQuadratsAsfalt);
        this.pesMaxim = pesMaxim;
    }

    public int getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(int pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    // Sempre carreteres donen true
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + ", pes màxim: " + pesMaxim + " kg";
    }
}
