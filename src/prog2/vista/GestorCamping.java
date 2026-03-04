package prog2.vista;

import prog2.model.Camping;
import prog2.model.InAllotjament;
import prog2.model.Allotjament;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

/**
 * Classe per gestionar els allotjaments del Càmping del Mar.
 * @author lauraigual
 */
public class GestorCamping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Camping campingMar = new Camping("Camping del Mar");

        omplirDadesModel(campingMar);
        
        ferReserves(campingMar);


        // Mostrar el número total d'allotjaments del Càmping i el número d'allotjaments que estan operatius amb el següent missatge:
        // >> El número total d'allotjaments del Càmping és X dels quals X allotjaments estan operatius.
        //--------------------------------------------------------------------------------------------------
        // Per completar

        int totalAllotjaments = campingMar.getNumAllotjaments();
        int operatius = campingMar.calculAllotjamentsOperatius();
        System.out.println(">> El número total d'allotjaments del Càmping és " + totalAllotjaments +
                " dels quals " + operatius + " allotjaments estan operatius.");

        // Mostrar l'allotjament amb estada mínima de la temporada alta més curta amb el següent missatge:
        // >> L'allotjament amb estada mínima de la temporada alta més curta és el següent:
        //--------------------------------------------------------------------------------------------------
        // Per completar

        // Assignem a allotjamentMesCurta l'estada més curta la qual poden estar segons la temporada
        Allotjament allotjamentMesCurta = campingMar.getAllotjamentEstadaMesCurta(InAllotjament.Temp.ALTA);

        // Mostrem el missatge
        System.out.println(">> L'allotjament amb estada mínima de la temporada alta més curta és el següent:");
        System.out.println(allotjamentMesCurta.toString());
       
    }

    /**
     * Mètode de classe per afegir parcel·les, bungalows, bungalows premium, glampings, mobil-home i clients al càmping.
     * @param camping L'objecte de tipus Camping que anem a omplir
     */
    private static void omplirDadesModel(Camping camping){


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "100P";

        float metres = 64.0f;
        boolean connexioElectrica = true;

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);

        nom = "Parcel·la Sud";
        idAllotjament = "101P";

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);


        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Est";
        idAllotjament = "102B";
        String mida = "Mitjana";

        int habitacions =2;
        int placesPersones = 6;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;


        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        nom = "Bungalow Oest";
        idAllotjament = "103B";
        habitacions =2;
        placesPersones = 4;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = true;

        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Nord";
        idAllotjament = "104BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 2;
        terrassa = true;
        tv= false;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        nom = "Bungallow Sud";
        idAllotjament = "105BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = false;
        serveisExtra = true;
        codiWifi = "CampingDelMarBP2";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "106G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        nom = "Glamping Sud";
        idAllotjament = "107G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        material = "Tela";
        casaMascota = false;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Nord";
        idAllotjament = "108MH";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        boolean terrassaBarbacoa = true;


        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);

        nom = "Mobil-Home Sud";
        idAllotjament = "109MH";
        mida = "Mitjana";
        habitacions =2;
        placesPersones = 4;
        terrassaBarbacoa = false;

        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);


        // Afegir clients:
        //------------------------------

        String nomClient="Patricia Fernandez";
        String dni="12345678X";
        camping.afegirClient(nomClient, dni);

        nomClient = "Lluís Plans";
        dni="78659101A";
        camping.afegirClient(nomClient, dni);

    }


    /**
     * Mètode per fer reserves d'allotjaments.
     * @param camping
     */
    private static void ferReserves(Camping camping){

        // 1. Afegeix una reserva pel client amb DNI "12345678X" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 20 de Febrer del 2026 i data de sortida 28 de febrer del 2026.



        // Declarar les variables de tipus String idAllotjament i dni.
        // Assigna els valors corresponents.

        String idAllotjament = "100P";
        String dni = "12345678X";


        // Crear una LocalDate per definir la data de la reserva.

        LocalDate dataEntrada = LocalDate.of(2026, 2, 20);
        LocalDate dataSortida = LocalDate.of(2026, 2, 28);

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.

        try{
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
            System.out.println("Reserva 1 realitzada correctament.");
        }catch(ExcepcioReserva e){
            System.out.println("Error en la reserva 1: " + e.getMessage());
        }
        
        // 2. Afegeix una reserva pel client amb DNI "78659101A" de l'allotjament amb identificador "100P"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables

        idAllotjament = "100P";
        dni = "78659101A";
        dataEntrada = LocalDate.of(2026, 2, 25);
        dataSortida = LocalDate.of(2026, 2, 28);

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.

        try {
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
            System.out.println("Reserva 2 realitzada correctament.");
        } catch (ExcepcioReserva e) {
            System.out.println("Error en la reserva 2: " + e.getMessage());
        }
           
        // 3. Afegeix una reserva pel client amb DNI "789101A" de l'allotjament amb identificador "300Z"
        // amb la data d'entrada 25 de Febrer del 2026 i data de sortida 28 de febrer del 2026.

        // Assigna els nous valors a les variables.    

        idAllotjament = "300Z";
        dni = "789101A";
        dataEntrada = LocalDate.of(2026, 2, 25);
        dataSortida = LocalDate.of(2026, 2, 28);

        // Intentar afegir la reserva amb la informació indicada i si no és possible mostrar el missatge d'error.

        try {
            camping.afegirReserva(idAllotjament, dni, dataEntrada, dataSortida);
            System.out.println("Reserva 3 realitzada correctament.");
        } catch (ExcepcioReserva e) {
            System.out.println("Error en la reserva 3: " + e.getMessage());
        }
        
    }
    
}
