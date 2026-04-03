package prog2.model;

import java.io.Serializable;

/**
 * Classe que representa una mobil-home del càmping.
 * Una mobil-home pot tenir terrassa amb barbacoa.
 *
 * @author Alberto
 */
public class MobilHome extends Casa implements Serializable {
    private boolean terrassaBarbacoa;
    /**
     * Constructor de la classe MobilHome.
     *
     * @param nom            Nom de la mobil-home.
     * @param id             Identificador únic.
     * @param mida           Mida ("Petita", "Mitjana" o "Gran").
     * @param habitacions    Nombre d'habitacions.
     * @param placesPersones Nombre màxim de persones.
     * @param terrassaBarbacoa True si té terrassa amb barbacoa.
     * @param estadaMinimaAlta  Dies mínims en temporada alta.
     * @param estadaMinimaBaixa Dies mínims en temporada baixa.
     */
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
