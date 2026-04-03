package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa un bungalow del càmping.
 * Un bungalow té places de pàrquing, terrassa, televisió i aire fred.
 *
 * @author Marti
 */

public class Bungalow extends Casa implements Serializable {
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;


    /**
     * Constructor de la classe Bungalow.
     *
     * @param nom            Nom del bungalow.
     * @param id             Identificador únic.
     * @param mida           Mida ("Petita", "Mitjana" o "Gran").
     * @param habitacions    Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param placesParquing Places de pàrquing disponibles.
     * @param terrassa       True si té terrassa, false altrament.
     * @param tv             True si té televisió, false altrament.
     * @param aireFred       True si té aire condicionat, false altrament.
     * @param estadaMinimaAlta  Dies mínims en temporada alta.
     * @param estadaMinimaBaixa Dies mínims en temporada baixa.
     */

    public Bungalow(String nom, String id, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }
    // Mètode que retorna les places de parquing
    public int getPlacesParquing(){ return this.placesParquing; }
    // Assigna el valor del paràmetre a placesParquing
    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }
    // Mètode que retorna si hi ha terrasa o no
    public boolean isTerrassa() { return this.terrassa; }
    // Assigna el valor del paràmetre a terrassa
    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }
    // Mètode que retorna si hi ha tv o no
    public boolean isTv() { return this.tv; }
    // Assigna el valor del paràmetre a tv
    public void setTv(boolean tv) { this.tv = tv; }
    // Mètode que retorna si hi ha aire fred o no
    public boolean isAireFred() { return this.aireFred; }
    // Assigna el valor del paràmetre a aireFred
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    /**
     * Retorna una representació textual del bungalow.
     *
     * @return String amb tota la informació del bungalow.
     */

    @Override
    public String toString() {
        // Informacio d'allotjament i casa (que ja esta en super.toString())
        String infoBase = super.toString();

        // Afegim l'informacio específica del bungalow
        return infoBase + " Bungalow{" +
                "placesParquing=" + this.placesParquing +
                ", terrassa=" + this.terrassa +
                ", tv=" + this.tv +
                ", aireFred=" + this.aireFred +
                "}";
    }
}
