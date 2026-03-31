package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CampingTest {

    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping("Camping Test");
        camping.inicialitzaDadesCamping();
    }

    // -------------------------
    // Constructor i getters
    // -------------------------
    @Test
    void testConstructor() {
        assertEquals("Camping Test", camping.getNomCamping());
    }

    // -------------------------
    // Llistar allotjaments
    // -------------------------
    @Test
    void testAfegirAllotjamentsOperatius() throws ExcepcioCamping{
        String resultat = camping.llistarAllotjaments("Operatiu");
        assertTrue(resultat.contains("ALL1"));
        assertTrue(resultat.contains("ALL2"));
    }

    @Test
    void testAfegirAllotjamentsNoOperatius() throws ExcepcioCamping{
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAllotjaments("No operatiu"));
    }

    @Test
    void testAfegirAllotjamentsInvalids() throws ExcepcioCamping{
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAllotjaments("Invalid"));
    }


    // -------------------------
    // Llistar accessos
    // -------------------------
    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String resultat = camping.llistarAccessos("Obert");
        assertTrue(resultat.contains("A1"));
        assertTrue(resultat.contains("A2"));
    }

    @Test
    void testLlistarAccessosTancats() {
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAccessos("Tancat"));
    }

    @Test
    void testLlistarAccessosInvalids() {
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAccessos("Invalid"));
    }

    // -------------------------
    // Tasques manteniment
    // -------------------------
    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping{
        camping.afegirTascaManteniment(1, "Reparacio", "ALL1", "2025-03-30", 3);
        String resultat = camping.llistarTasquesManteniment();
        assertTrue(resultat.contains("1"));
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping{
        camping.afegirTascaManteniment(1, "Reparacio", "ALL1", "2025-03-30", 3);

        camping.completarTascaManteniment(1);
        assertThrows(ExcepcioCamping.class, () -> camping.llistarTasquesManteniment());
    }

    @Test
    void testAfegirTascaAllotjamentNoExisteix() {
        assertThrows(ExcepcioCamping.class, () -> camping.afegirTascaManteniment(1, "Reparacio", "NO_EXISTEIX", "2025-03-30", 3));
    }

    // -------------------------
    // Calculs
    // -------------------------
    @Test
    void testCalculaAccessosNoAccessibles() {
        assertEquals(6, camping.calculaAccessosNoAccessibles());
    }

    @Test
    void testCalculaMetresTerra() {
        assertEquals(1630, camping.calculaMetresTerra(), 0.01);
    }

    // -------------------------
    // Persistència
    // -------------------------
    @Test
    void testSaveAndLoad() throws ExcepcioCamping {
        String fitxer = "test_camping_temp.dat";
        camping.save(fitxer); // Guardem
        Camping campingCarregat = Camping.load(fitxer);
        assertEquals(camping.getNomCamping(), campingCarregat.getNomCamping());
        // Netejar
        new java.io.File(fitxer).delete();
    }
}
