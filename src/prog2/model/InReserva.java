package prog2.model;

import java.time.LocalDate;

public interface InReserva {

    public Allotjament getAllotjament_();

    public Client getClient();

    public LocalDate getDataEntrada();

    public LocalDate getDataSortida();

    public void setAllotjament_(Allotjament allotjament_);

    public void setClient(Client client_);

    public void setDataEntrada(LocalDate dataEntrada_);

    public void setDataSortida(LocalDate dataSortida_);

}
