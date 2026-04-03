package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Classe que gestiona una llista d'allotjaments.
 * Permet afegir, eliminar, buscar i llistar allotjaments segons el seu estat.
 *
 * @author Alberto
 */
public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    private ArrayList<Allotjament> allotjaments;

    /*Inicialitza la llista buida
    *
    */
    public LlistaAllotjaments(){
        this.allotjaments = new ArrayList<>();
    }

    /**
     * Afegeix un allotjament a la llista.
     *
     * @param allotjament Allotjament a afegir.
     * @throws ExcepcioCamping Si l'allotjament és null.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament introdüit no pot ser null. ");
        }
        allotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        allotjaments.clear();
    }

    /**
     * Retorna un String amb tots els allotjaments que tenen l'estat indicat.
     *
     * @param estat "Operatiu" o "No operatiu".
     * @return String amb la informació dels allotjaments.
     * @throws ExcepcioCamping Si no hi ha allotjaments amb l'estat indicat.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        // Filtrem estats
        boolean operatiu;
        if (estat.equalsIgnoreCase("Operatiu")) { // No sé bé que pot ser estat, suposo que es No operatiu o Operatiu.
            operatiu = true;
        } else if (estat.equalsIgnoreCase("No operatiu")) { // Utlitzo a les dues comparacions equalsIgnoreCase que es el mateix que equals pero no l'importa si el string esta en majuscules i tal, com no se que pot ser "estat" va molt bé.
            operatiu = false;
        } else {
            throw new ExcepcioCamping("Estat no vàlid. Ha de ser 'Operatiu' o 'No Operatiu'");
        }
        StringBuilder resultat = new StringBuilder(); // StringBuilder es com StringBuffer pero mes rapid
        boolean trobat = false;
        for (Allotjament a : allotjaments) {
            if (a.isOperatiu() == operatiu) {
                resultat.append(a.toString()).append("\n");
                trobat = true;
            }
        }

        // Si no trobo ningún, llanço excepció.
        if (!trobat) {
            throw new ExcepcioCamping("No hi ha allotjaments " + estat + "s");
        }

        return resultat.toString();
    }

    /**
     * Comprova si hi ha algun allotjament operatiu a la llista.
     *
     * @return true si n'hi ha algun, false si no.
     */
    @Override
    public boolean containsAllotjamentOperatiu() {
        for(Allotjament a:allotjaments){
            if(a.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprova si un allotjament concret és a la llista.
     *
     * @param allotjament Allotjament a cercar.
     * @return true si hi és, false si no.
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament a : allotjaments) {
            if (a.equals(allotjament)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cerca un allotjament pel seu identificador.
     *
     * @param id Identificador de l'allotjament.
     * @return L'allotjament trobat.
     * @throws ExcepcioCamping Si no existeix cap allotjament amb aquest id.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        throw new ExcepcioCamping("L'allotjament amb id " + id + " no existeix");
    }
}
