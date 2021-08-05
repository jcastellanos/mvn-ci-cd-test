package co.jcastellanos.test.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IdUtilTest {

    @Test
    @DisplayName("Generacion de un identificador.")
    public void generate1() {
        String id = IdUtil.generate();
        assertEquals(32, id.length());
    }
    
    @Test
    @DisplayName("Generacion de un identificador. Deben ser aleatorios")
    public void generate2() {
        String id1 = IdUtil.generate();
        String id2 = IdUtil.generate();
        assertNotEquals(id1, id2);
    }
}
