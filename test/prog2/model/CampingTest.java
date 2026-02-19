package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CampingTest {

    private Camping camping;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    @BeforeEach
    void setUp() {
        camping = new Camping("Camping Test");

        dataEntrada = LocalDate.of(2026, 5, 1);
        dataSortida = LocalDate.of(2026, 5, 10);

    }

    // -------------------------
    // Constructor i getters
    // -------------------------
    @Test
    void testConstructor() {
        assertEquals("Camping Test", camping.getNom());
        assertEquals(0, camping.getNumAllotjaments());
        assertEquals(0, camping.getNumClients());
        assertEquals(0, camping.getNumReserves());
    }

    // -------------------------
    // Clients
    // -------------------------
    @Test
    void testAfegirClient() {
        camping.afegirClient("Anna", "12345678A");

        assertEquals(1, camping.getNumClients());
        assertEquals("Anna", camping.getLlistaClients().get(0).getNom());
        assertEquals("12345678A", camping.getLlistaClients().get(0).getDni());
    }

    // -------------------------
    // Allotjaments
    // -------------------------
    @Test
    void testAfegirAllotjaments() {
        camping.afegirParcela("Parcela 1", "P1", 30.5f, true);

        camping.afegirBungalow(
                "Bungalow 1", "B1", "Gran",
                2, 4, 1, true, true, true
        );
        assertEquals(2, camping.getNumAllotjaments());
    }


    // -------------------------
    // Reserves
    // -------------------------
    @Test
    void testAfegirReservaCorrecta() throws ExcepcioReserva {
        camping.afegirClient("Joan", "11111111A");
        camping.afegirParcela("Parcela 1", "P1", 25f, true);


        camping.afegirReserva("P1", "11111111A", dataEntrada, dataSortida);

        assertEquals(1, camping.getNumReserves());
    }

    @Test
    void testAfegirReservaAllotjamentNoExisteix() {
        // Intentem fer una reserva amb un id d'allotjament que no existeix
        camping.afegirClient("Joan", "11111111A");

        ExcepcioReserva ex = assertThrows(ExcepcioReserva.class, () ->
                camping.afegirReserva("NO_EXISTEIX", "11111111A", dataEntrada, dataSortida)
        );

        assertEquals("L'allotjament amb id NO_EXISTEIX no existeix", ex.getMessage());
    }

    @Test
    void testAfegirReservaClientNoExisteix() {
        // Intentem fer una reserva amb un DNI de client que no existeix
        camping.afegirParcela("Parcela 1", "P1", 25f, true);

        ExcepcioReserva ex = assertThrows(ExcepcioReserva.class, () ->
                camping.afegirReserva("P1", "99999999Z", dataEntrada, dataSortida)
        );

        assertEquals("El client amb DNI 99999999Z no existeix", ex.getMessage());
    }

    // -------------------------
    // Càlculs
    // -------------------------
    @Test
    void testCalculAllotjamentsOperatius() {
        camping.afegirParcela("Parcela 1", "P1", 20f, true);
        camping.afegirParcela("Parcela 2", "P2", 20f, false);

        int operatius = camping.calculAllotjamentsOperatius();

        assertTrue(operatius >= 0);
        assertTrue(operatius <= camping.getNumAllotjaments());
    }

    // -------------------------
    // Temporades
    // -------------------------
    @Test
    void testGetTemporadaAlta() {
        LocalDate data = LocalDate.of(2026, 7, 15);
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(data));
    }

    @Test
    void testGetTemporadaBaixa() {
        LocalDate data = LocalDate.of(2026, 1, 10);
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(data));
    }

    @Test
    void testGetTemporada() {
        // Comprova que la temporada de 4 dates diferents es torna correctament.
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(LocalDate.of(2026, 6, 1)));
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(LocalDate.of(2026, 12, 1)));
        assertEquals(InAllotjament.Temp.ALTA, Camping.getTemporada(LocalDate.of(2026, 3, 21)));
        assertEquals(InAllotjament.Temp.BAIXA, Camping.getTemporada(LocalDate.of(2026, 3, 20)));
    }
}
