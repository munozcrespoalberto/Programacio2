package prog2.model;

public class MobilHome extends Casa {
    private boolean terrasaBarbacoa;
    // Aquí irán los atributos y métodos
    public MobilHome(boolean terrasaBarbacoa, String mida, int numHabitacions, int Persones, String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(mida, numHabitacions, Persones, nom, id, estadaMinimaAlta, estadaMinimaBaixa);
        this.terrasaBarbacoa = terrasaBarbacoa;
    }
    // Mètode que retorna si hi ha terrasa + barbacoa o no
    public boolean isTerrasaBarbacoa() { return this.terrasaBarbacoa; }
    // Assigna el valor del paràmetre a terrasaBarbacoa
    public void setTerrasaBarbacoa(boolean terrasaBarbacoa) {
        this.terrasaBarbacoa = terrasaBarbacoa;
    }

    //Comprova el funcionament (si te terrasa + barbacoa funciona)
    @Override
    public boolean correcteFuncionament(){
        return this.terrasaBarbacoa;
    }

    @Override
    public String toString() {
        // Primero obtenemos la información de Casa (que ya incluye la de Allotjament)
        String infoBase = super.toString();

        // Añadimos la información específica de MobilHome
        return infoBase + " MobilHome{terrassaBarbacoa=" + terrasaBarbacoa + "}";
    }
}
