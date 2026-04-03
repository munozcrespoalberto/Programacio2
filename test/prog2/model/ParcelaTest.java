
package prog2.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelaTest {

    private Parcela parcela;

    // Avans de cualsevol test:
    @BeforeEach
    void setUp() {
        parcela = new Parcela("Parcela A", "P001", 50.0f, true);
    }

    // Test de constructor i getters
    @Test
    void testConstructor() {
        Parcela p = new Parcela("Parcela A", "P001", 50.0f, true);
        assertEquals("Parcela A", p.getNom());
        assertEquals("P001", p.getId());
        assertEquals(50.0f, p.getMida());
        assertTrue(p.isConnexioElectrica());
        assertTrue(p.isOperatiu());         // per defecte operatiu
        assertEquals("100%", p.getIluminacio()); // per defecte 100%
        String expected = "Nom=Parcela A, Id=P001, estada mínima en temp ALTA: 4, estada mínima en temp BAIXA: 2, Operatiu: Sí, Iluminacio: 100%.";
        assertTrue(p.toString().contains(expected));
    }

    // test get i set Nom
    @Test
    void testNom() {
        parcela.setNom("Parcela B");
        assertEquals("Parcela B", parcela.getNom());
        parcela.setNom("Parcela 2");
        assertEquals("Parcela 2", parcela.getNom());
    }

    @Test
    void testID() {
        parcela.setId("P002");
        assertEquals("P002", parcela.getId());
        parcela.setId("P009");
        assertEquals("P009", parcela.getId());
    }

    @Test
    void testObrirAllotjament() {
        parcela.obrirAllotjament();
        assertEquals("100%",parcela.getIluminacio());
        assertTrue(parcela.isOperatiu());
    }

    @Test
    void testTancarAllotjament() {
        TascaManteniment tasca = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.Neteja, parcela, "2026-01-01", 3);
        parcela.tancarAllotjament(tasca);
        assertFalse(parcela.isOperatiu());
        assertEquals("100%", parcela.getIluminacio()); // Neteja → 100%
    }

    @Test
    void testMida() {
        assertEquals(50.0f, parcela.getMida());
        parcela.setMida(60.0f);
        assertEquals(60.0f, parcela.getMida());
    }

    @Test
    void testElectricitat() {
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.isConnexioElectrica());
        parcela.setConnexioElectrica(true);
        assertTrue(parcela.isConnexioElectrica());
    }

    @Test
    void testToString() {
        String expected = "Nom=Parcela A, Id=P001, estada mínima en temp ALTA: 4, estada mínima en temp BAIXA: 2, Operatiu: Sí, Iluminacio: 100%.";
        assertTrue(parcela.toString().contains(expected));
    }
}
