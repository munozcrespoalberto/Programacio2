package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BungalowPremiumTest {

    private BungalowPremium bungalowPremium;

    @BeforeEach
    void setUp(){
        bungalowPremium = new BungalowPremium("Bungalow Premium Test", "BP001", "Gran", 2, 6, 1,
                true, true, true, true, "WIFI123", 7, 4);
    }

    @Test
    void testConstructor(){
        assertEquals("Bungalow Premium Test", bungalowPremium.getNom());
        assertEquals("BP001", bungalowPremium.getId());
        assertEquals("Gran", bungalowPremium.getMida());
        assertEquals(2, bungalowPremium.getNumHabitacions());
        assertEquals(6, bungalowPremium.getPersones());
        assertEquals(1, bungalowPremium.getPlacesParquing());
        assertTrue(bungalowPremium.isTerrassa());
        assertTrue(bungalowPremium.isTv());
        assertTrue(bungalowPremium.isAireFred());
        assertTrue(bungalowPremium.isServeisExtra());
        assertEquals("WIFI123", bungalowPremium.getCodiWifi());
    }

    @Test
    void testSetters(){
        bungalowPremium.setServeisExtra(false);
        assertFalse(bungalowPremium.isServeisExtra());

        bungalowPremium.setCodiWifi("NEWWIFI999");
        assertEquals("NEWWIFI999", bungalowPremium.getCodiWifi());

        bungalowPremium.setPlacesParquing(2);
        assertEquals(2, bungalowPremium.getPlacesParquing());

        bungalowPremium.setTerrassa(false);
        assertFalse(bungalowPremium.isTerrassa());
    }

    @Test
    void testToString(){
        String resultat = bungalowPremium.toString();
        assertTrue(resultat.contains("BungalowPremium"));
        assertTrue(resultat.contains("serveisExtra=true"));
        assertTrue(resultat.contains("codiWifi=WIFI123"));
        assertTrue(resultat.contains("BP001"));
    }

    @Test
    void testHerenciaAllotjament(){
        assertEquals(7, bungalowPremium.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(4, bungalowPremium.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertTrue(bungalowPremium.isOperatiu());
        assertEquals("100%", bungalowPremium.getIluminacio());
    }

}
