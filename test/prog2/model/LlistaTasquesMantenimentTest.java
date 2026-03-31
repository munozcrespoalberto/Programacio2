package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaTasquesMantenimentTest {

    private LlistaTasquesManteniment llista;
    private Parcela parcela;
    private Parcela parcela2;

    @BeforeEach
    void setUp(){
        llista = new LlistaTasquesManteniment();
        parcela = new Parcela("Parcela Nord", "ALL1", 64.0f, true);
        parcela2 = new Parcela("Parcela Sud", "ALL2", 64.0f, true);
    }

    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2025-03-30", 3);
        assertEquals(1, llista.getTascaManteniment(1).getNum());
        assertFalse(parcela.isOperatiu()); // Allotjament s'ha de tancar
        assertEquals("50%", parcela.getIluminacio()); // Reparacio = 50%
    }

    @Test
    void testAfegirTascaNeteja() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Neteja", parcela, "2025-03-30", 2);
        assertEquals("100%", parcela.getIluminacio()); // Neteja = 100%
    }

    @Test
    void testAfegirTascaRevisioTecnica() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "RevisioTecnica", parcela, "2025-03-30", 2);
        assertEquals("50%", parcela.getIluminacio()); // Revisio = 50%
    }

    @Test
    void testAfegirTascaDesinfeccio() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Desinfeccio", parcela, "2025-03-30", 3);
        assertEquals("0%", parcela.getIluminacio()); // Desinfeccio = 0%
    }

    @Test
    void testAfegirTascaDuplicada() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2025-03-30", 3);
        assertThrows(ExcepcioCamping.class, () -> llista.afegirTascaManteniment(2, "Neteja", parcela, "2025-03-30", 2));
    }

    @Test
    void testAfegirTascaTipusInvalid(){
        assertThrows(ExcepcioCamping.class, () -> llista.afegirTascaManteniment(1, "TipusInvalid", parcela, "2025-03-30", 3));
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2025-03-30", 3);
        TascaManteniment tasca = llista.getTascaManteniment(1);
        llista.completarTascaManteniment(tasca);
        assertThrows(ExcepcioCamping.class, () -> llista.getTascaManteniment(1));
        assertTrue(parcela.isOperatiu());
        assertEquals("100%", parcela.getIluminacio());
    }

    @Test
    void testCompletarTascaInexistent() {
        TascaManteniment tasca = new TascaManteniment(99, TascaManteniment.TipusTascaManteniment.Reparacio, parcela, "2025-03-30", 3);
        assertThrows(ExcepcioCamping.class, () -> llista.completarTascaManteniment(tasca));
    }

    @Test
    void testLlistarTasquesManteniment() throws ExcepcioCamping{
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2025-03-30", 3);
        llista.afegirTascaManteniment(2, "Neteja", parcela2, "2025-03-30", 2);

        String resultat = llista.llistarTasquesManteniment();
        assertTrue(resultat.contains("1"));
        assertTrue(resultat.contains("2"));
        assertTrue(resultat.contains("Reparacio"));
        assertTrue(resultat.contains("Neteja"));
    }

    @Test
    void testLlistarTasquesBuida(){
        assertThrows(ExcepcioCamping.class, () -> llista.llistarTasquesManteniment());
    }

    @Test
    void testGetMantenimentNoExistent(){
        assertThrows(ExcepcioCamping.class, () -> llista.getTascaManteniment(99));
    }
}
