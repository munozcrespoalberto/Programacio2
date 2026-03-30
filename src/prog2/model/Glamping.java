package prog2.model;

import java.io.Serializable;

public class Glamping extends Casa implements Serializable {
    private String material;
    private boolean casaMascota;
    public Glamping(String nom, String id, String mida, int habitacions, int placesPersones, String material, boolean casaMascota, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }
    // Mètode que retorna el material del Glamping
    public String getMaterial() { return material; }
    // Assigna el valor del paràmetre a material
    public void setMaterial(String material) { this.material = material; }

    // Mètode que retorna si hi ha o no una casa per mascotes
    public boolean isCasaMascota() { return this.casaMascota; }
    // Assigna el valor del paràmetre a casaMascota
    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public String toString() {
        // Primero obtenemos la información de Casa (que ya incluye la de Allotjament)
        String infoBase = super.toString();

        // Añadimos la información específica de Glamping
        return infoBase + " Glamping{material=" + material +
                ", casaMascota=" + casaMascota + "}";
    }
}
