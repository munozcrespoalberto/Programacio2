package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;
    // Aquí irán los atributos y métodos
    public MobilHome(String nom, String id, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa, mida, habitacions, placesPersones);
        this.terrassaBarbacoa = terrassaBarbacoa;
    }
    // Mètode que retorna si hi ha terrasa + barbacoa o no
    public boolean isTerrassaBarbacoa() { return this.terrassaBarbacoa; }
    // Assigna el valor del paràmetre a terrassaBarbacoa
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    @Override
    public String toString() {
        // Primero obtenemos la información de Casa (que ya incluye la de Allotjament)
        String infoBase = super.toString();

        // Añadimos la información específica de MobilHome
        return infoBase + " MobilHome{terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}
