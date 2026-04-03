package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llista;
    private CamiAsfalt camiAsfalt;
    private CarreteraAsfalt carreteraAsfalt;
    private CamiTerra camiTerra;
    private CarreteraTerra carreteraTerra;

    @BeforeEach
    void setUp(){
        llista = new LlistaAccessos();
        camiAsfalt = new CamiAsfalt("A1", 200);
        carreteraAsfalt = new CarreteraAsfalt("A2", 800, 10000);
        camiTerra = new CamiTerra("A3", 100);
        carreteraTerra = new CarreteraTerra("A4", 200, 4);
    }

    @Test
    void testAfegirAcces(){
        llista.afegirAcces(camiAsfalt);
        assertDoesNotThrow(() -> llista.llistarAccessos(true));
    }

    @Test
    void testAfegirAccesNull(){
        assertThrows(ExcepcioCamping.class, () -> llista.afegirAcces(null));
    }

    @Test
    void testBuidar(){
        llista.afegirAcces(camiAsfalt);
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> llista.llistarAccessos(true));
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping{
        llista.afegirAcces(camiAsfalt);
        llista.afegirAcces(carreteraAsfalt);

        String resultat = llista.llistarAccessos(true);
        assertTrue(resultat.contains("A1"));
        assertTrue(resultat.contains("A2"));
    }

    @Test
    void testLlistarAccessosTancats() throws ExcepcioCamping{
        camiAsfalt.tancarAcces();
        llista.afegirAcces(camiAsfalt);
        llista.afegirAcces(carreteraAsfalt);

        String resultat = llista.llistarAccessos(false);
        assertTrue(resultat.contains("A1"));
        assertFalse(resultat.contains("A2"));

    }

    @Test
    void testActualitzaEstatAccessosAmbAllotjamentOperatiu(){
        // Creem un allotjament operatiu i l'afegim a l'accés
        Parcela parcela = new Parcela("Parcela Test", "ALL1", 50.0f, true);
        camiAsfalt.afegirAllotjament(parcela);
        llista.afegirAcces(camiAsfalt);

        // L'acces ha d'estar obert perqu el'allotjament està operatiu
        llista.actualitzaEstatAccessos();
        assertTrue(camiAsfalt.getEstat());
    }

    @Test
    void testActualitzaEstatAccessosSenseAllotjamentOperatiu(){
        // Creem un allotjament no operatiu i l'afegim a l'accés
        Parcela parcela = new Parcela("Parcela Test", "ALL1", false, "100%", 50.0f, true);
        camiAsfalt.afegirAllotjament(parcela);
        llista.afegirAcces(camiAsfalt);

        llista.actualitzaEstatAccessos();
        assertFalse(camiAsfalt.getEstat());
    }

    @Test
    void testCalculaAccessosNoAccessibles() {
        llista.afegirAcces(camiAsfalt); // accessibilitat = false
        llista.afegirAcces(carreteraAsfalt); // accessibilitat = true
        assertEquals(1, llista.calculaAccessosNoAccessibles());
    }

    @Test
    void testCalculMetresTerra(){
        llista.afegirAcces(camiTerra); // Longitud = 100
        llista.afegirAcces(carreteraTerra); // Longitud = 200
        assertEquals(300, llista.calculaMetresTerra(), 0.01);
    }

    @Test
    void testCalclaMetresTerraNomesAccesosAsfalt(){
        llista.afegirAcces(camiAsfalt);
        llista.afegirAcces(carreteraAsfalt);
        assertThrows(ExcepcioCamping.class, () -> llista.calculaMetresTerra());
    }


















}
