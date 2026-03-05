package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import prog2.vista.ExcepcioReserva;


public class Camping implements InCamping{
    private String nom;
    private ArrayList<Allotjament> allotjaments;
    private ArrayList<Client> clients;
    private LlistaReserves reserves;

    //Constructor de camping només amb nom
    public Camping(String nom) {
        this.nom = nom;
        this.allotjaments = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reserves = new LlistaReserves();
    }

    //Constructor complert
    public Camping(String nom,  ArrayList<Allotjament> allotjaments, ArrayList<Client> clients, LlistaReserves reserves) {
        this.nom = nom;
        this.allotjaments = allotjaments;
        this.clients = clients;
        this.reserves = reserves;
    }
    // Mètode que retorna el nom del camping
    public String getNom(){ return this.nom; }
    //Retorna la llista de reserves del camping.
    public LlistaReserves getLlistaReserves(){ return this.reserves; }
    //Retorna la llista d'allotjaments del camping
    public ArrayList<Allotjament> getLlistaAllotjaments(){ return this.allotjaments; }
    //Retorna la llista de clients del camping
    public ArrayList<Client> getLlistaClients(){ return this.clients; }
    //Retorna el número total d'allotjaments del càmping
    public int getNumAllotjaments(){ return this.allotjaments.size(); }
    //Retorna el número total de reserves del càmping
    public int getNumReserves(){ return this.reserves.getNumReserves(); }
    //Retorna el número total de clients del càmping
    public int getNumClients(){ return this.clients.size(); }

    //Crea un nou objecte de tipus Client i l'afegeix a la llista de clients
    public void afegirClient(String nom_, String dni_){
        Client client = new Client(nom_, dni_);
        this.clients.add(client);
    }

    //Afegeix una nova parcel·la a la llista d'allotjaments
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        this.allotjaments.add(parcela);
    }

    //Afegeix un nou bungalow a la llista d'allotjaments
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, 7, 4);
        allotjaments.add(bungalow);
    }

    //Afegeix un bungalow premium a la llista d'allotjaments
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi, 7, 4);
        allotjaments.add(bungalowPremium);
    }

    //Afegeix una casa glamping a la llista d'allotjaments
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota, 3, 3);
        allotjaments.add(glamping);
    }

    //Afegeix una mobil-home a la llista d'allotjaments
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa, 5, 3);
        allotjaments.add(mobilHome);
    }

    //Metode privat creat per no haver de posar tot a afegirReserva. Busca un allotjament associat amb un id concret
    private Allotjament buscarAllotjament(String id_) {
        Iterator<Allotjament> it = allotjaments.iterator();
        while (it.hasNext()) { //Mentre quedin elements
            Allotjament a = it.next(); //Seguent element
            if (a.getId().equals(id_)) {
                return a;
            }
        }
        return null;
    }

    //El mateix que el metode de buscarAllotjament pero amb Clients i el seu DNI
    private Client buscarClient(String dni_) {
        Iterator<Client> it = clients.iterator(); //Iterador de la llista de clients
        while (it.hasNext()) {
            Client client = it.next(); //Anem client en client
            if (client.getDni().equals(dni_)) {
                return client; // Si trobem un client amb aquest dni
            }
        }
        return null;
    }

    //Afegeix una nova reserva al càmping
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        Allotjament allotjament = buscarAllotjament(id_);
        if(allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix"); //No existeix un allotjament amb aquest id
        }
        Client client = buscarClient(dni_);
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix"); //No existeix un client amb aquest id
        }
        reserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    //Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius
    public int calculAllotjamentsOperatius() {
        int operatius = 0;
        Iterator<Allotjament> it = this.allotjaments.iterator();
        while (it.hasNext()) {
            Allotjament a = it.next();
            if (a.correcteFuncionament()) {
                operatius++;
            }
        }
        return operatius; //Nombre d'allotjaments operatius
    }

    //Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        if(allotjaments.isEmpty()) {
            return null;
        }
        Iterator<Allotjament> it = allotjaments.iterator();
        Allotjament mesCurta = it.next(); //Primer element
        long minEstada = mesCurta.getEstadaMinima(temp);
        while (it.hasNext()) {
            Allotjament a = it.next();
            long estada = a.getEstadaMinima(temp);
            if (estada < minEstada) {
                minEstada = estada;
                mesCurta = a;
            }
        }
        return mesCurta;
    }

    //Identifica en quina temporada estem segons la data
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        // Temporada alta: 21 març a 20 setembre
        if ((mes == 3 && dia >= 21) || (mes > 3 && mes < 9) || (mes == 9 && dia <= 20)) {
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }
}
