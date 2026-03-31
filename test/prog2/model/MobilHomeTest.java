package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MobilHomeTest {

    private MobilHome mobilHome;

    @BeforeEach
    void setUp() {
        mobilHome = new MobilHome(
                "MobilHome Test", "M001", "Petita", 1, 2,
                true, 5, 3);
    }

    @Test
    void testConstructor() {
        assertEquals("MobilHome Test", mobilHome.getNom());
        assertEquals("M001", mobilHome.getId());
        assertEquals("Petita", mobilHome.getMida());
        assertEquals(1, mobilHome.getNumHabitacions());
        assertEquals(2, mobilHome.getPersones());
        assertTrue(mobilHome.isTerrassaBarbacoa());
    }

    @Test
    void testSetters() {
        mobilHome.setTerrassaBarbacoa(false);
        assertFalse(mobilHome.isTerrassaBarbacoa());

        mobilHome.setMida("Gran");
        assertEquals("Gran", mobilHome.getMida());

        mobilHome.setNumHabitacions(2);
        assertEquals(2, mobilHome.getNumHabitacions());

        mobilHome.setPersones(4);
        assertEquals(4, mobilHome.getPersones());
    }

    @Test
    void testToString() {
        String resultat = mobilHome.toString();
        assertTrue(resultat.contains("MobilHome"));
        assertTrue(resultat.contains("terrassaBarbacoa=true"));
        assertTrue(resultat.contains("M001"));
    }

    @Test
    void testHerenciaAllotjament() {
        assertEquals(5, mobilHome.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(3, mobilHome.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertTrue(mobilHome.isOperatiu());
        assertEquals("100%", mobilHome.getIluminacio());
    }

}
