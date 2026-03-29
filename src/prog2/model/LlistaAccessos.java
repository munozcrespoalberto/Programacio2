package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> accessos;
    public LlistaAccessos(){
        this.accessos = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if(acc == null){
            throw new ExcepcioCamping("L'acces introdüit no pot ser null. ");
        }
        accessos.add(acc);
    }

    @Override
    public void buidar() {
        accessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder resultat = new StringBuilder(); // StringBuilder es com StringBuffer pero mes rapid
        boolean trobat = false;
        for (Acces a : accessos) {
            if (a.getEstat() == estat) {
                resultat.append(a.toString()).append("\n");
                trobat = true;
            }
        }

        // Si no trobo ningún, llanço excepció.
        if (!trobat) {
            throw new ExcepcioCamping("No hi ha accessos " + (estat ? "oberts" : "tancats"));
        }
        // Passo l'StringBuilder a string normal
        return resultat.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for(Acces acces : accessos){
            acces.tancarAcces();
            if(acces.getAAllotjaments().containsAllotjamentOperatiu()){
                acces.obrirAcces();
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int contador = 0;
        for(Acces a: accessos){
            if(!a.isAccessibilitat()){
                contador += 1;
            }
        }
        
        if(contador == 0){
            throw new ExcepcioCamping("No hi han accessos no accessibles. ");
        }
        return contador;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float longitudTotal = 0;
        for(Acces acces: accessos){
            if(acces instanceof AccesTerra){
                AccesTerra accesTerra = (AccesTerra)acces;
                longitudTotal += accesTerra.getLongitud();
            }
        }
        if (longitudTotal == 0) {
            throw new ExcepcioCamping("No hi han accessos de terra. ");
        }
        return longitudTotal;
    }
}
