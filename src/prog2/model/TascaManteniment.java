package prog2.model;
import java.io.Serializable;

/**
 * Representa una tasca de manteniment associada a un allotjament.
 * Cada tasca té un número únic, un tipus, una data i una durada prevista.
 *
 * @author Marti
 */
public class TascaManteniment implements InTascaManteniment, Serializable {

    // Enum amb els tipus de tasques
    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }

    private int num;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;

    /**
     * Constructor de la tasca de manteniment.
     *
     * @param num        Número identificador únic.
     * @param tipus      Tipus de tasca (Reparacio, Neteja, etc.).
     * @param allotjament Allotjament on s'ha de fer la tasca.
     * @param data       Data de registre.
     * @param dies       Dies previstos per completar la tasca.
     */

    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data,
    int dies){

        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;

    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return tipus;
    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus) {
        this.tipus = tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    @Override
    public void setDies(int dies) {
        this.dies = dies;
    }


    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca.
     *
     * @return "50%" per Reparacio i RevisioTecnica, "100%" per Neteja, "0%" per Desinfeccio.
     */
    @Override
    public String getIluminacioAllotjament() {
        switch(tipus){
            case Reparacio:
                return "50%";
            case Neteja:
                return "100%";
            case RevisioTecnica:
                return "50%";
            case Desinfeccio:
                return "0%";
            default:
                return "100%";
        }
    }

    @Override
    public String toString(){
        return "Tasca " + num + ": " + tipus + " a l'allotjament " + allotjament.getId() +
                " (" + allotjament.getNom() + ")" + ", Data: " + data + " , Dies: " + dies;
    }
}
