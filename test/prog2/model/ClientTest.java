package prog2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client("Anna", "12345678A");
    }

    @Test
    void testConstructorIGets() {
        assertEquals("Anna", client.getNom());
        assertEquals("12345678A", client.getDni());
    }

    @Test
    void testSetNom() {
        client.setNom("Marc");
        assertEquals("Marc", client.getNom());
    }

    @Test
    void testSetDni() {
        client.setDni("87654321B");
        assertEquals("87654321B", client.getDni());
    }

    @Test
    void testToString() {
        String esperat = "Anna amb DNI: 12345678A. ";
        assertEquals(esperat, client.toString());
    }
}
