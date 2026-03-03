package prog2.model;

import prog2.vista.ExcepcioReserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{

    private ArrayList<Reserva> reserves;

    public LlistaReserves(){
        this.reserves = new ArrayList<>();
    }

    // Retorna el numero total de reserves
    @Override
    public int getNumReserves(){
        return this.reserves.size();
    }

    // Diu si esta disponible o si no ho esta
    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        for(Reserva r : this.reserves){
            // Ens interesen les reserves del mateix allotjament
            if(r.getAllotjament_().equals(allotjament)){
                LocalDate entradaExist = r.getDataEntrada();
                LocalDate sortidaExist = r.getDataSortida();

                // Retorna fals si les dates es creuen
                if(dataEntrada.isBefore(sortidaExist) && dataSortida.isAfter(entradaExist)){
                    return false;
                }
            }
        }
        // En cas contrari retorna true
        return true;
    }


    // Mira si complex el minim segons la temporada
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        // Guardem una variable que seran els dies entre l'entrada i la sortida
        long diesEstada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);
        long estadaMinima = allotjament.getEstadaMinima(temporada);

        // Si ho compleix retornarà true i en el cas contrari false
        return diesEstada >= estadaMinima;
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        if(!isEstadaMinima(allotjament, dataEntrada, dataSortida)){
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " + client.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");
        }

        if(!allotjamentDisponible(allotjament, dataEntrada, dataSortida)){
            throw new ExcepcioReserva("L'allotjament amb identificador " + allotjament.getId() +
                            " no està disponible en la data demanada " + dataEntrada +
                            " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".");
        }
        // Crear i afegir la reserva
        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        this.reserves.add(novaReserva);
    }
}





