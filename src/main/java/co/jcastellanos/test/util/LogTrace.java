package co.jcastellanos.test.util;

import org.slf4j.Logger;

public final class LogTrace {
    
    /**
     * Esta clase es utilitaria y no puede ser instanceada.
     */
    private LogTrace() {
        
    }
    /**
     * Deja una traza del metodo desde donde se invoca para hacer debug de codigo.
     * @param logger Loggger para realizar la traza.
     */
    public static void trace(Logger logger) {
        logger.debug(Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
