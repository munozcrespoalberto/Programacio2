
package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BungalowTest {

    private Bungalow bungalow;
    private BungalowPremium bungalowPremium;

    @BeforeEach
    void setUp() {
        bungalow = new Bungalow("Bungalow Nord", "ALL3", "22 m²", 2, 4, 1, true, true, true, 7, 4);
        bungalowPremium = new BungalowPremium("Bungalow Sud", "ALL4", "27 m²", 2, 6, 1, true, true, true, true, "WIFI123", 7, 4);
    }

    // Test de constructor i getters
    @Test
    void testConstructor() {
        assertEquals("Bungalow Nord", bungalow.getNom());
        assertEquals("Bungalow Sud", bungalowPremium.getNom());
        assertEquals("ALL3", bungalow.getId());
        assertEquals("ALL4", bungalowPremium.getId());
        assertEquals("22 m²", bungalow.getMida());
        assertEquals("27 m²", bungalowPremium.getMida());
        assertEquals(2, bungalow.getNumHabitacions());
        assertEquals(2, bungalowPremium.getNumHabitacions());
        assertEquals(4, bungalow.getPersones());
        assertEquals(6, bungalowPremium.getPersones());
        assertEquals(1, bungalow.getPlacesParquing());
        assertEquals(1, bungalowPremium.getPlacesParquing());
        assertTrue(bungalow.isTerrassa());
        assertTrue(bungalowPremium.isTerrassa());
        assertTrue(bungalow.isTv());
        assertTrue(bungalowPremium.isTv());
        assertTrue(bungalow.isAireFred());
        assertTrue(bungalowPremium.isAireFred());
        assertTrue(bungalowPremium.isServeisExtra());
        assertEquals("WIFI123", bungalowPremium.getCodiWifi());
        assertEquals(7, bungalow.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(4, bungalow.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertEquals(7, bungalowPremium.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(4, bungalowPremium.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    @Test
    void testSetters() {
        bungalow.setPlacesParquing(3);
        assertEquals(3, bungalow.getPlacesParquing());

        bungalow.setTerrassa(false);
        assertFalse(bungalow.isTerrassa());

        bungalow.setTv(false);
        assertFalse(bungalow.isTv());

        bungalow.setAireFred(false);
        assertFalse(bungalow.isAireFred());
    }

    @Test
    void testSettersPremium() {
        bungalowPremium.setServeisExtra(false);
        assertFalse(bungalowPremium.isServeisExtra());

        bungalowPremium.setCodiWifi("WIFI999");
        assertEquals("WIFI999", bungalowPremium.getCodiWifi());
    }

    @Test
    void testToString() {
        assertTrue(bungalow.toString().contains("Bungalow Nord"));
        assertTrue(bungalow.toString().contains("ALL3"));
        assertTrue(bungalow.toString().contains("placesParquing=1"));
    }
}
