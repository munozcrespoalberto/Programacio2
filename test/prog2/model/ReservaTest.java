package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private Reserva reserva;

    @BeforeEach
    public void setUp() throws ExcepcioReserva {
        // Inicialitzem els objectes necessaris per a les proves
        allotjament =  new Parcela("Parcela A", "P1", 50.0f, true);
        client = new Client("Laura", "123456789");

        dataEntrada = LocalDate.of(2026, 5, 1);
        dataSortida = LocalDate.of(2026, 5, 10);

        // Creem la reserva amb els objectes creats
       reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);

    }

    @Test
    public void testReservaConstructor() {
        // Comprovem que el constructor ha assignat correctament els valors
        assertEquals(allotjament, reserva.getAllotjament_());
        assertEquals(client, reserva.getClient());
        assertEquals(dataEntrada, reserva.getDataEntrada());
        assertEquals(dataSortida, reserva.getDataSortida());
    }

    @Test
    void testReservaDatesIncorrectes() {
        // Comprovem que es llança l'excepció si li passem les dates al revés (primer data de sortida i després data d'entrada)
        ExcepcioReserva ex = assertThrows(ExcepcioReserva.class, () ->
                new Reserva(allotjament, client, dataSortida, dataEntrada)
        );

        assertEquals( "La data de sortida no pot ser abans de la data d'entrada", ex.getMessage());

    }


    @Test
    public void testGetters() {
        // Comprovem que els getters tornen els valors correctes
        assertEquals(allotjament, reserva.getAllotjament_());
        assertEquals(client, reserva.getClient());
        assertEquals(dataEntrada, reserva.getDataEntrada());
        assertEquals(dataSortida, reserva.getDataSortida());
    }

    @Test
    public void testSetters() {
        // Canviem els valors fent servir els setters
        Allotjament nouAllotjament = new Parcela("Parcela A", "P2", 50.0f, true);
        Client nouClient = null;
        nouClient = new Client("Carlos", "987654321");

        LocalDate novaDataEntrada = LocalDate.of(2026, 6, 1);
        LocalDate novaDataSortida = LocalDate.of(2026, 6, 5);

        reserva.setAllotjament_(nouAllotjament);
        reserva.setClient(nouClient);
        reserva.setDataEntrada(novaDataEntrada);
        reserva.setDataSortida(novaDataSortida);

        // Comprovem que els valors han sigut modificats correctament
        assertEquals(nouAllotjament, reserva.getAllotjament_());
        assertEquals(nouClient, reserva.getClient());
        assertEquals(novaDataEntrada, reserva.getDataEntrada());
        assertEquals(novaDataSortida, reserva.getDataSortida());
    }



    @Test
    public void testInvalidDates() {
        // Comprovem que no es permet una reserva amb dates inválides (de sortida abans de la entrada)
        LocalDate dataEntradaIncorrecta = LocalDate.of(2026, 5, 10);
        LocalDate dataSortidaIncorrecta = LocalDate.of(2026, 5, 1);

        assertThrows(ExcepcioReserva.class, () -> {
            new Reserva(allotjament, client, dataEntradaIncorrecta, dataSortidaIncorrecta);
        });
    }
}
