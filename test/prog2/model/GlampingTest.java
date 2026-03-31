package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GlampingTest {

    private Glamping glamping;

    @BeforeEach
    void setUp(){
        glamping = new Glamping("Glamping Test", "G001", "Mitjana", 1, 2,
                "Tela", true, 5, 3);
    }

    @Test
    void testConstructor() {
        assertEquals("Glamping Test", glamping.getNom());
        assertEquals("G001", glamping.getId());
        assertEquals("Mitjana", glamping.getMida());
        assertEquals(1, glamping.getNumHabitacions());
        assertEquals(2, glamping.getPersones());
        assertEquals("Tela", glamping.getMaterial());
        assertTrue(glamping.isCasaMascota());
    }

    @Test
    void testSetters() {
        glamping.setMaterial("Fusta");
        assertEquals("Fusta", glamping.getMaterial());

        glamping.setCasaMascota(false);
        assertFalse(glamping.isCasaMascota());

        glamping.setMida("Gran");
        assertEquals("Gran", glamping.getMida());

        glamping.setNumHabitacions(2);
        assertEquals(2, glamping.getNumHabitacions());

        glamping.setPersones(4);
        assertEquals(4, glamping.getPersones());
    }

    @Test
    void testToString() {
        String resultat = glamping.toString();
        assertTrue(resultat.contains("Glamping"));
        assertTrue(resultat.contains("material=Tela"));
        assertTrue(resultat.contains("casaMascota=true"));
        assertTrue(resultat.contains("G001"));
    }

    @Test
    void testHerenciaAllotjament() {
        assertEquals(5, glamping.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(3, glamping.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertTrue(glamping.isOperatiu());
        assertEquals("100%", glamping.getIluminacio());
    }

}
