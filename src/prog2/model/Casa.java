package prog2.model;

import java.io.Serializable;
/**
 * Classe abstracta que representa una casa del càmping.
 * Les cases tenen mida, nombre d'habitacions i places per a persones.
 * Les subclasses són Bungalow, Glamping i MobilHome.
 *
 * @author Alberto
 */
public abstract class Casa extends Allotjament implements Serializable {
    private String mida;
    private int numHabitacions;
    private int persones;

    /**
     * Constructor de la classe Casa.
     *
     * @param nom             Nom de la casa.
     * @param id              Identificador únic.
     * @param estadaMinimaAlta  Dies mínims en temporada alta.
     * @param estadaMinimaBaixa Dies mínims en temporada baixa.
     * @param mida            Mida de la casa ("Petita", "Mitjana" o "Gran").
     * @param numHabitacions  Nombre d'habitacions.
     * @param persones        Nombre màxim de persones.
     */
    public Casa(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa, String mida, int numHabitacions, int persones) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.persones = persones;
    }
    // Mètode que retorna la mida
    public String getMida(){
        return this.mida;
    }
    // Assigna el valor del paràmetre a mida
    public void setMida(String mida) {
        this.mida = mida;
    }

    // Mètode que retorna el número d'habitacions
    public int getNumHabitacions() {
        return this.numHabitacions;
    }
    // Assigna el valor del paràmetre a numHabitacions
    public void setNumHabitacions(int numHabitacions) { this.numHabitacions = numHabitacions; }

    // Mètode que retorna el número de persones
    public int getPersones() { return this.persones;}
    // Assigna el valor del paràmetre a persones
    public void setPersones(int persones) { this.persones = persones; }
}
