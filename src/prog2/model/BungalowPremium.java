package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;

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
