package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {

    /*
    * Aquesta classe que gestiona la llista de tasques de manteniment del camping permetent afegir,
    * completar i llistar tasques.
    * També ens ajuda a no tenir més d'una tasca activa a la vegada.
    * */

    private ArrayList<TascaManteniment> tasques;

    // constructor que inicialitza llistes buides
    public LlistaTasquesManteniment(){
        this.tasques = new ArrayList<>();
    }


    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        Iterator<TascaManteniment> it = tasques.iterator();
        while (it.hasNext()){
            TascaManteniment t = it.next();
            if (t.getAllotjament().getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("L'allotjament " + allotjament.getId() + " ja té una tasca de manteniment activa.");
            }
        }

        // Convertim tipus de String a l'enum
        TascaManteniment.TipusTascaManteniment tipusEnum;

        try{
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        }catch(IllegalArgumentException e){
            throw new ExcepcioCamping("El tipus '" + tipus + "' no és vàlid. Els tipus vàlids són: Reparacio, Neteja, RevisioTecnica, Desinfeccio.");
        }

        // Creem la tasca i l'afegim
        TascaManteniment tasca = new TascaManteniment(num, tipusEnum, allotjament, data, dies);
        tasques.add(tasca);

        // Tancar l'allotjament
        allotjament.tancarAllotjament(tasca);

    }

    // Completa una tasca de manteniment i obre l'allotjament
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

        Iterator<TascaManteniment> it = tasques.iterator();
        while (it.hasNext()){
            TascaManteniment t = it.next();
            if (t.getNum() == tasca.getNum()){
                it.remove();
                tasca.getAllotjament().obrirAllotjament();
                return;
            }
        }
        throw new ExcepcioCamping("La tasca número " + tasca.getNum() + " no existeix a la llista.");

    }

    // Retorna un Strinb amb l'informació de les tasques actives
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {

        if(tasques.isEmpty()){
            throw new ExcepcioCamping("No hi ha cap tasca de manteniment activa.");
        }
        // Utilitzem string builder per crear l'string de forma més comoda
        StringBuilder resultat = new StringBuilder();
        Iterator<TascaManteniment> it = tasques.iterator();
        while (it.hasNext()){
            resultat.append(it.next().toString()).append("\n");
        }
        return resultat.toString();
    }

    // Busca i retorna la tasca amb el número identificador donat
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {

        Iterator<TascaManteniment> it = tasques.iterator();
        while(it.hasNext()){
            TascaManteniment t = it.next();
            if (t.getNum() == num){
                return t;
            }
        }
        throw new ExcepcioCamping("No existeix cap tasca amb el número " + num + ".");
    }
}







