package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llista;
    private Parcela parcela1;
    private Parcela parcela2;

    @BeforeEach
    void setUp(){
        llista = new LlistaAllotjaments();
        parcela1 = new Parcela("Parcela Nord", "ALL1",64.0f, true);
        parcela2 = new Parcela("Parcela Sud", "ALL2", 64.0f, true);
    }

    @Test
    void testAfegirAllotjament(){
        llista.afegirAllotjament(parcela1);
        assertDoesNotThrow(() -> llista.getAllotjament("ALL1"));
    }

    @Test
    void testAfegirAllotjamentNull(){
        assertThrows(ExcepcioCamping.class, () -> llista.afegirAllotjament(null));
    }

    @Test
    void testBuidar(){
        llista.afegirAllotjament(parcela1);
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> llista.getAllotjament("ALL1"));
    }

    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        llista.afegirAllotjament(parcela1);
        llista.afegirAllotjament(parcela2);

        String resultat = llista.llistarAllotjaments("Operatiu");
        assertTrue(resultat.contains("Parcela Nord"));
        assertTrue(resultat.contains("Parcela Sud"));
    }

    @Test
    void testLlistarAllotjamentNoOperatius() throws ExcepcioCamping{
        parcela1.setOperatiu(false);
        llista.afegirAllotjament(parcela1);
        llista.afegirAllotjament(parcela2);

        String resultat = llista.llistarAllotjaments("No operatiu");
        assertTrue(resultat.contains("Parcela Nord"));
        assertFalse(resultat.contains("Parcela Sud"));
    }

    @Test
    void testLlistarAllotjamentsEstatInvalid(){
        assertThrows(ExcepcioCamping.class, () -> llista.llistarAllotjaments("Invalid"));
    }

    @Test
    void testContainsAllotjamentOperatiu(){
        llista.afegirAllotjament(parcela1);
        assertTrue(llista.containsAllotjamentOperatiu());

        parcela1.setOperatiu(false);
        assertFalse(llista.containsAllotjamentOperatiu());
    }

    @Test
    void testContains(){
        llista.afegirAllotjament(parcela1);
        assertTrue(llista.contains(parcela1));
        assertFalse(llista.contains(parcela2));
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping{
        llista.afegirAllotjament(parcela1);
        assertEquals(parcela1, llista.getAllotjament("ALL1"));
    }

    @Test
    void testGetAllotjamentNoExisteix(){
        assertThrows(ExcepcioCamping.class, () -> llista.getAllotjament("NO_EXISTEIX"));
    }
}
