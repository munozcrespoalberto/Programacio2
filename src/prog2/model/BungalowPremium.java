package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa un bungalow premium del càmping.
 * A més dels atributs d'un bungalow normal, inclou serveis extra i codi Wi-Fi.
 *
 * @author Marti
 */
public class BungalowPremium extends Bungalow implements Serializable {
    private boolean serveisExtra;
    private String codiWifi;

    /**
     * Constructor de la classe BungalowPremium.
     *
     * @param nom            Nom del bungalow premium.
     * @param id             Identificador únic.
     * @param mida           Mida ("Petita", "Mitjana" o "Gran").
     * @param habitacions    Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param placesParquing Places de pàrquing disponibles.
     * @param terrassa       True si té terrassa.
     * @param tv             True si té televisió.
     * @param aireFred       True si té aire condicionat.
     * @param serveisExtra   True si inclou llençols i tovalloles.
     * @param codiWifi       Codi de la xarxa Wi-Fi.
     * @param estadaMinimaAlta  Dies mínims en temporada alta.
     * @param estadaMinimaBaixa Dies mínims en temporada baixa.
     */
    public BungalowPremium(String nom, String id, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, id, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, estadaMinimaAlta, estadaMinimaBaixa);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }
    // Mètode que retorna si hi han llençols i tovalloles o no
    public boolean isServeisExtra() { return this.serveisExtra; }
    // Assigna el valor del paràmetre a llencolsTovalloles
    public void setServeisExtra(boolean serveisExtra) { this.serveisExtra = serveisExtra; }
    // Mètode que retorna si hi ha wifi gratis o no
    public String getCodiWifi() { return this.codiWifi; }
    // Assigna el valor del paràmetre a codiWifi
    public void setCodiWifi(String codiWifi) { this.codiWifi = codiWifi; }

    @Override
    public String toString() {
        String infoBase = super.toString();
        return infoBase + " BungalowPremium{serveisExtra=" + serveisExtra + ", codiWifi=" + codiWifi + "}";
    }
}
