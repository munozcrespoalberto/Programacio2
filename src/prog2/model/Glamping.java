package prog2.model;

public class Glamping extends Casa {
    private String materialGlamping;
    private boolean casaMascota;
    public Glamping(String materialGlamping, boolean casaMascota, String mida, int numHabitacions, int Persones, String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(mida, numHabitacions, Persones, nom, id, estadaMinimaAlta, estadaMinimaBaixa);
        this.materialGlamping = materialGlamping;
        this.casaMascota = casaMascota;
    }
    // Mètode que retorna el material del Glamping
    public String getMaterialGlamping() { return materialGlamping; }
    // Assigna el valor del paràmetre a materialGlamping
    public void setMaterialGlamping(String materialGlamping) { this.materialGlamping = materialGlamping; }

    // Mètode que retorna si hi ha o no una casa per mascotes
    public boolean isCasaMascota() { return this.casaMascota; }
    // Assigna el valor del paràmetre a casaMascota
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament(){
        return this.casaMascota;
    }

    @Override
    public String toString() {
        // Primero obtenemos la información de Casa (que ya incluye la de Allotjament)
        String infoBase = super.toString();

        // Añadimos la información específica de Glamping
        return infoBase + " Glamping{material=" + materialGlamping +
                ", casaMascota=" + casaMascota + "}";
    }
}
