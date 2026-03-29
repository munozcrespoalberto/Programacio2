package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable { // Serializable es per poder utilitzar ObjectOutputStream...
    private ArrayList<Allotjament> allotjaments;
    public LlistaAllotjaments(){
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) {
            throw new ExcepcioCamping("L'allotjament introdüit no pot ser null. ");
        }
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

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

    @Override
    public boolean containsAllotjamentOperatiu() {
        for(Allotjament a:allotjaments){
            if(a.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for (Allotjament a : allotjaments) {
            if (a.equals(allotjament)) {
                return true;
            }
        }
        return false;
    }

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
