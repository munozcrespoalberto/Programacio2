package prog2.model;

import java.time.LocalDate;
import java.util.ArrayList;
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
        for (Allotjament a : allotjaments) {
            if (a.getId().equals(id_)) { //Si el id que busquem es el mateix que el del allotjament que estem mirant, l'hem trobat
                return a;
            }
        }
        //Retornem null si no trobem l'ajotllament amb l'id indicat
        return null;
    }

    //El mateix que el metode de buscarAllotjament pero amb Clients i el seu DNI
    private Client buscarClient(String dni_) {
        for (Client a : clients) {
            if(a.getDni().equals(dni_)) {
                return a;
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
        for (Allotjament a : this.allotjaments) { //Per cada iteracio, l'element de la llista numero(iteracio), s'asigna a "a" com a objecte de tipus Allotjament
            if (a.correcteFuncionament()) {
                operatius++;
            }
        }
        return operatius; //Numero de allotjaments operatius
    }

    //Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp){
        if(allotjaments.isEmpty()) {
            return null;
        }
        Allotjament mesCurta = allotjaments.get(0); //Agafo el primer element d'allotjaments
        long minEstada = mesCurta.getEstadaMinima(temp); //Agafem l'estada minima del primer element, a partir d'aquesta farem el bucle
        for (Allotjament a : allotjaments) {
            long estada = a.getEstadaMinima(temp); //La estada mes curta del nou element en temporada alta
            if (estada < minEstada) { //En cas de que la del nou element sigui mes curta que la de l'anterior, es substitueixen minEstada i mesCurta per les dades d'aquest nou allotjament
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
