package prog2.model;

import java.io.Serializable;

public class CarreteraAsfalt extends AccesAsfalt implements Serializable {
    int pesMaxim;

    // Constructor amb estat donat
    public CarreteraAsfalt(String nom, boolean estat, float metresQuadratsAsfalt, int pesMaxim) {
        super(nom, estat, metresQuadratsAsfalt);
        this.pesMaxim = pesMaxim;
    }

    // Constructor sense estat donat
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
