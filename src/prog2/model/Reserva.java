package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;

public class Reserva implements InReserva{

    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament  allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
            if(dataEntrada.isAfter(dataSortida)){
                throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
            }
            this.allotjament = allotjament;
            this.client = client;
            this.dataEntrada = dataEntrada;
            this.dataSortida = dataSortida;

    }

    @Override
    public Allotjament getAllotjament_(){
        return this.allotjament;
    }

    @Override
    public Client getClient(){
        return this.client;
    }

    @Override
    public LocalDate getDataEntrada(){
        return this.dataEntrada;
    }

    @Override
    public LocalDate getDataSortida() {
        return this.dataSortida;
    }

    @Override
    public void setAllotjament_(Allotjament allotjament_){
        this.allotjament = allotjament_;
    }

    @Override
    public void setClient(Client client_){
        this.client = client_;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_){
        this.dataEntrada = dataEntrada_;
    }

    @Override
    public void setDataSortida(LocalDate dataSortida_){
        this.dataSortida = dataSortida_;

    }


}



















