package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;

    public BungalowPremium(boolean serveisExtra, String codiWifi, int placesParquing, boolean terrassa, boolean televisio, boolean aireFred, String mida, int numHabitacions, int Persones, String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa){
        super(placesParquing, terrassa, televisio, aireFred, mida, numHabitacions, Persones, nom, id, 7, 4);
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
    public boolean correcteFuncionament(){
        // Comprovo que no sigui null perque en cas de ser null, els .length() donarà error i les comparacions també.
        return isAireFred() && codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }
    @Override
    public String toString() {
        String infoBase = super.toString();
        return infoBase + " BungalowPremium{serveisExtra=" + serveisExtra + ", codiWifi=" + codiWifi + "}";
    }
}
