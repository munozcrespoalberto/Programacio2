package prog2.model;

public class Bungalow extends Casa{
    private int placesParquing;
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

    public Bungalow(int placesParquing, boolean terrassa, boolean televisio, boolean aireFred, String mida, int numHabitacions, int Persones, String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa){
        super(mida, numHabitacions, Persones, nom, id, 7, 4);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.televisio = televisio;
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
    // Mètode que retorna si hi ha televisio o no
    public boolean isTelevisio() { return this.televisio; }
    // Assigna el valor del paràmetre a televisio
    public void setTelevisio(boolean televisio) { this.televisio = televisio; }
    // Mètode que retorna si hi ha aire fred o no
    public boolean isAireFred() { return this.aireFred; }
    // Assigna el valor del paràmetre a aireFred
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    @Override
    public boolean correcteFuncionament(){
        return this.aireFred;
    }

    @Override
    public String toString() {
        // Informacio d'allotjament i casa (que ja esta en super.toString())
        String infoBase = super.toString();

        // Afegim l'informacio específica del bungalow
        return infoBase + " Bungalow{" +
                "placesParquing=" + this.placesParquing +
                ", terrassa=" + this.terrassa +
                ", televisio=" + this.televisio +
                ", aireFred=" + this.aireFred +
                "}";
    }
}
