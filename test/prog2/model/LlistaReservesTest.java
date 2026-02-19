
package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import prog2.vista.ExcepcioReserva;

public class LlistaReservesTest {

    private LlistaReserves llistaReserves;
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    @BeforeEach
    public void setUp() {
        // Inicialització dels objectes necessaris abans de cada prova
        llistaReserves = new LlistaReserves();
        allotjament = new Parcela("Parcela A", "P001", 50.0f, true);
        client = new Client("Client1", "123456789");
        dataEntrada = LocalDate.of(2026, 5, 15);
        dataSortida = LocalDate.of(2026, 5, 20);
    }

    /**
     * Prova que es pot afegir una reserva quan l'allotjament està disponible
     */
    @Test
    public void testAfegirReservaDisponible() throws ExcepcioReserva {

        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);

        assertEquals(1, llistaReserves.getNumReserves());
    }

    /**
     * Prova que no es pot afegir una reserva quan l'allotjament no està disponible
     */
    @Test
    public void testAfegirReservaNoDisponible() throws ExcepcioReserva {

        // Afegim la primera reserva
        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);

        // Creem un nou client
        Client client2;
        client2 = new Client("Client2", "012345678");

        // Intentem afegir una segona reserva per al mateix allotjament amb dates superposades
        LocalDate novaDataEntrada = LocalDate.of(2026, 5, 18);
        LocalDate novaDataSortida = LocalDate.of(2026, 5, 22);

        ExcepcioReserva excepcio = assertThrows(ExcepcioReserva.class, () -> {
            llistaReserves.afegirReserva(allotjament, client2, novaDataEntrada, novaDataSortida);
        });

        assertTrue(excepcio.getMessage().contains("no està disponible"));
    }

    /**
     * Comprova que l'estada mínima es compleixi
     */
    @Test
    void testEstadaMinima() throws ExcepcioReserva {
        // Arrange
        Allotjament allotjament = new Parcela("Parcela A", "P001", 50.0f, true);
        allotjament.setEstadaMinima(7, 0); // Estada mínima de 7 dies en temporada alta i de 0 dies en temporada baixa.

        LocalDate dataEntrada = LocalDate.of(2026, 7, 1);

        // ---------
        // Estada massa curta → ha de fallar
        // ---------
        LocalDate dataSortidaCurta = LocalDate.of(2026, 7, 5); // 4 dies

        ExcepcioReserva excepcio = assertThrows(ExcepcioReserva.class, () -> llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortidaCurta));

        assertTrue(excepcio.getMessage().toLowerCase().contains("estada mínima"), "El missatge ha d'indicar que no es compleix l'estada mínima"
        );

        // ---------
        // Estada correcta → NO ha de fallar
        // ---------
        LocalDate dataSortidaLonga = LocalDate.of(2026, 7, 8); // 7 dies

        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortidaLonga);

        assertEquals(1, llistaReserves.getNumReserves());
    }

}

