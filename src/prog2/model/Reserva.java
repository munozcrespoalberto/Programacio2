package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;

public class Reserva implements InReserva{

    // Atributs de la classe Reserva
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament  allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        // Validació que les dates són correctes
        if(dataEntrada.isAfter(dataSortida)){
                throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
            }
            this.allotjament = allotjament;
            this.client = client;
            this.dataEntrada = dataEntrada;
            this.dataSortida = dataSortida;

    }

    @Override
    //  Getter de l'allotjament que retorna allotjament
    public Allotjament getAllotjament_(){
        return this.allotjament;
    }

    @Override
    // Getter del client
    public Client getClient(){
        return this.client;
    }

    @Override
    // Getter de la data d'entrada
    public LocalDate getDataEntrada(){
        return this.dataEntrada;
    }

    @Override
    // Getter de la data de sortida
    public LocalDate getDataSortida() {
        return this.dataSortida;
    }

    @Override
    // Setter de l'allotjament, assigna el valor del paràmetre a allotjament
    public void setAllotjament_(Allotjament allotjament_){
        this.allotjament = allotjament_;
    }

    @Override
    // Setter de client
    public void setClient(Client client_){
        this.client = client_;
    }

    @Override
    // Setter de la data d'entrada
    public void setDataEntrada(LocalDate dataEntrada_){
        this.dataEntrada = dataEntrada_;
    }

    @Override
    // Setter de la data de sortida
    public void setDataSortida(LocalDate dataSortida_){
        this.dataSortida = dataSortida_;

    }


}



















