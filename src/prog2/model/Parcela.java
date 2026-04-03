package prog2.model;
import java.io.Serializable;

/**
 * Classe que representa una parcel·la del càmping.
 * Una parcel·la té una mida en metres quadrats i pot tenir connexió elèctrica.
 *
 * @author Marti
 */
public class Parcela extends Allotjament implements Serializable {

    private float mida;
    private boolean electricitat;

    /**
     * Constructor principal de la parcel·la.
     * Crea una parcel·la amb nom, id, mida i connexió elèctrica.
     * L'estat operatiu i la il·luminació s'inicialitzen al constructor d'Allotjament.
     *
     * @param nom            Nom de la parcel·la.
     * @param id             Identificador únic.
     * @param mida           Mida en metres quadrats.
     * @param electricitat   True si té connexió elèctrica, false altrament.
     */
    public Parcela(String nom, String id, float mida, boolean electricitat) {
        super(nom, id, 4, 2);
        this.mida = mida;
        this.electricitat = electricitat;
        // operatiu = true i iluminacio = 100%. Aquestos s'inicialitzen al constructor d'Allotjament
    }

    /**
     * Constructor addicional per als tests.
     * Permet crear una parcel·la especificant també l'estat operatiu i la il·luminació.
     *
     * @param nom          Nom de la parcel·la.
     * @param id           Identificador únic.
     * @param operatiu     Estat operatiu (true = operatiu, false = no operatiu).
     * @param iluminacio   Percentatge d'il·luminació ("100%", "50%" o "0%").
     * @param mida         Mida en metres quadrats.
     * @param electricitat True si té connexió elèctrica.
     */
    public Parcela(String nom, String id, boolean operatiu, String iluminacio, float mida, boolean electricitat) {
        super(nom, id, 4, 2); // estades mínimes per defecte
        this.mida = mida;
        this.electricitat = electricitat;
        setOperatiu(operatiu);
        setIluminacio(iluminacio);
    }

    // Mètode que retorna la mida de la parcel·la
    public float getMida(){
        return this.mida;
    }

    // Assigna el valor del paràmetre a mida
    public void setMida(float mida){
        this.mida = mida;
    }

    // Mètode que ens diu si te connexió elèctrica
    public boolean isConnexioElectrica(){
        return this.electricitat;
    }

    // Assigna el valor del paràmetre a electricitat
    public void setConnexioElectrica(boolean electricitat){
        this.electricitat = electricitat;
    }

    // Mètode que ens mostra les característiques que te la parcel·la
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + this.mida + ", connexioElectrica=" + this.electricitat + "}";
    }
}

