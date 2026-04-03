package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una carretera de terra.
 * Les carreteres de terra permeten l'accés amb vehicle i tenen una amplada.
 *
 * @author Alberto
 */
public class CarreteraTerra extends AccesTerra implements Serializable {
    int amplada;

    // Constructor amb estat donat
    public CarreteraTerra(String nom, boolean estat, float longitud, int amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    // Constructor sense estat donat
    public CarreteraTerra(String nom, float longitud, int amplada) {
        super(nom, longitud);
        this.amplada = amplada;
    }

    public int getAmplada() {
        return amplada;
    }

    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    // Sempre carreteres donen true
    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + ", amplada: " + amplada + " metres";
    }
}
