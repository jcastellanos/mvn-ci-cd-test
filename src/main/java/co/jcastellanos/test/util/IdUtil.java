package co.jcastellanos.test.util;

import java.util.UUID;

public final class IdUtil {
    
    /**
     * Constructor privado. Esta clase no puede ser instanceada.
     */
    private IdUtil() {
        
    }

    /**
     * Genera un identificador aleatorio de 32 caracteres.
     * @return Cadena con el identificador.
     */
    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
