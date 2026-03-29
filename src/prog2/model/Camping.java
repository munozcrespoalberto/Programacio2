package prog2.model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import prog2.vista.ExcepcioCamping;


public class Camping implements InCamping, Serializable { // Serializable es per poder utilitzar ObjectOutputStream...
    private String nom;
    private LlistaAllotjaments allotjaments;
    private LlistaAccessos accessos;
    private LlistaTasquesManteniment tasques;

    // Constructor de camping, només nom i inicialitzar llistes
    public Camping(String nom) {
        this.nom = nom;
        this.allotjaments = new LlistaAllotjaments();
        this.accessos = new LlistaAccessos();
        this.tasques = new LlistaTasquesManteniment();
    }

    @Override
    public String getNomCamping() {
        return this.nom;
    }

    // Llista els allotjaments amb l'estat indicat sempre i quan estat sigui "Operatiu" o "No operatiu"
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if(estat == null) {
            throw new ExcepcioCamping("Estat ha de ser Operatiu o No operatiu");
        } else if (!estat.equalsIgnoreCase("Operatiu") && !estat.equalsIgnoreCase("No operatiu")) {
            throw new ExcepcioCamping("Estat ha de ser 'Operatiu' o 'No operatiu'.");
        }
        return allotjaments.llistarAllotjaments(estat);
    }

    // Llista els accessos amb l'estat indicat sempre i quan infoEstat sigui "Obert" o "Tancat"
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean obert;
        if (infoEstat.equalsIgnoreCase("Obert")) { // No sé bé que pot ser estat, suposo que es No operatiu o Operatiu.
            obert = true;
        } else if (infoEstat.equalsIgnoreCase("Tancat")) { // Utlitzo a les dues comparacions equalsIgnoreCase que es el mateix que equals pero no l'importa si el string esta en majuscules i tal, com no se que pot ser "estat" va molt bé.
            obert = false;
        } else {
            throw new ExcepcioCamping("Estat no vàlid. Ha de ser 'Obert' o 'Tancat'.");
        }
        return accessos.llistarAccessos(obert);
    }

    // Llista les tasques de manteniment
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return tasques.llistarTasquesManteniment();
    }

    // Primer agafa l'allotjament amb l'id donat, si no hi ha llança excepció. Després d'agafar l'allotjament, li afegeix una tasca de manteniment
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = allotjaments.getAllotjament(idAllotjament);
        tasques.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        accessos.actualitzaEstatAccessos();
    }

    // Completa la tasca amb el numero indicat i despres actualitza els estats dels accessos
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        tasques.completarTascaManteniment(tasques.getTascaManteniment(num));
        accessos.actualitzaEstatAccessos();
    }

    // Utilitza el metode calculaAccessosNoAccessibles de LlistaAccessos
    @Override
    public int calculaAccessosNoAccessibles() {
        try {
            return accessos.calculaAccessosNoAccessibles();
        } catch (ExcepcioCamping e) {
            return 0;
        }
    }

    // Utilitza el metode calculaMetresTerra de LlistaAccessos
    @Override
    public float calculaMetresTerra() {
        try {
            return accessos.calculaMetresTerra();
        } catch (ExcepcioCamping e) {
            return 0;
        }
    }

    // Guarda l'objecte Camping complert en un arxiu utilitzant ObjectOutputStream.
    public void save(String camiDesti) throws ExcepcioCamping {
        // try-with-resources = tanca automaticament els arxius al final del try catch.
        // ObjectOutputStream = escriure al fitxer
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) { // FileOutputStream crea un nou arxiu i ObjectOutputStream ens permet modificar-ho
            oos.writeObject(this); // Escriu dins l'arxiu l'objecte actual,
        } catch (IOException e) {
            throw new ExcepcioCamping("Error en guardar el camping: " + e.getMessage());
        }
    }

    // Load es com un getCamping pero totes les dades del camping han passat per un arxiu quan feiem el save.
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        // ObjectInputStream = llegir el fitxer
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            return (Camping) ois.readObject(); // retorna el nostre camping, com un getCamping
        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("Error en carregar el camping: " + e.getMessage());
        }
    }

    @Override
    public void inicialitzaDadesCamping() {

        // ========== ALOJAMIENTOS ==========

        // Parcelas
        Parcela parcelaNord = new Parcela("Parcella Nord", "ALL1", 64, true);
        Parcela parcelaSud = new Parcela("Parcella Sud", "ALL2", 64, true);
        allotjaments.afegirAllotjament(parcelaNord);
        allotjaments.afegirAllotjament(parcelaSud);

        // Bungalow
        Bungalow bungalowNord = new Bungalow("Bungalow Nord", "ALL3", "22 m²", 2, 4, 1, true, true, true, 7, 4);
        allotjaments.afegirAllotjament(bungalowNord);

        // Bungalow Premium
        BungalowPremium bungalowSud = new BungalowPremium("Bungalow Sud", "ALL4", "27 m²", 2, 6, 1, true, true, true, true, "WIFI123", 7, 4);
        allotjaments.afegirAllotjament(bungalowSud);

        // Glamping
        Glamping glampingNord = new Glamping("Glamping Nord", "ALL5", "20 m²", 1, 2, "tela", true, 5, 3);
        allotjaments.afegirAllotjament(glampingNord);

        // MobilHome
        MobilHome mobilHomeSud = new MobilHome("Mobil-Home Sud", "ALL6", "22 m²", 2, 4, true, 5, 3);
        allotjaments.afegirAllotjament(mobilHomeSud);

        // ========== ACCESOS ==========

        // A1: Camí asfaltat
        CamiAsfalt a1 = new CamiAsfalt("A1", 200);
        a1.afegirAllotjament(parcelaNord);
        a1.afegirAllotjament(parcelaSud);
        accessos.afegirAcces(a1);

        // A2: Carretera asfaltada
        CarreteraAsfalt a2 = new CarreteraAsfalt("A2", 800, 10000);
        a2.afegirAllotjament(parcelaNord);
        a2.afegirAllotjament(parcelaSud);
        accessos.afegirAcces(a2);

        // A3: Camí de terra
        CamiTerra a3 = new CamiTerra("A3", 100);
        a3.afegirAllotjament(bungalowNord);
        accessos.afegirAcces(a3);

        // A4: Carretera de terra
        CarreteraTerra a4 = new CarreteraTerra("A4", 200, 3);
        a4.afegirAllotjament(bungalowNord);
        accessos.afegirAcces(a4);

        // A5: Camí asfaltat
        CamiAsfalt a5 = new CamiAsfalt("A5", 350);
        a5.afegirAllotjament(bungalowSud);
        accessos.afegirAcces(a5);

        // A6: Carretera asfaltada
        CarreteraAsfalt a6 = new CarreteraAsfalt("A6", 800, 12000);
        a6.afegirAllotjament(bungalowSud);
        accessos.afegirAcces(a6);

        // A7: Camí asfaltat
        CamiAsfalt a7 = new CamiAsfalt("A7", 100);
        a7.afegirAllotjament(glampingNord);
        a7.afegirAllotjament(mobilHomeSud);
        accessos.afegirAcces(a7);

        // A8: Carretera asfaltada
        CarreteraAsfalt a8 = new CarreteraAsfalt("A8", 800, 10000);
        a8.afegirAllotjament(glampingNord);
        a8.afegirAllotjament(mobilHomeSud);
        accessos.afegirAcces(a8);

        // A9: Camí de terra
        CamiTerra a9 = new CamiTerra("A9", 50);
        a9.afegirAllotjament(parcelaSud);
        accessos.afegirAcces(a9);

        // A10: Carretera de terra
        CarreteraTerra a10 = new CarreteraTerra("A10", 400, 4);
        a10.afegirAllotjament(parcelaSud);
        accessos.afegirAcces(a10);

        // A11: Camí de terra
        CamiTerra a11 = new CamiTerra("A11", 80);
        a11.afegirAllotjament(mobilHomeSud);
        accessos.afegirAcces(a11);

        // A12: Carretera de terra
        CarreteraTerra a12 = new CarreteraTerra("A12", 800, 5);
        a12.afegirAllotjament(mobilHomeSud);
        accessos.afegirAcces(a12);
    }
}