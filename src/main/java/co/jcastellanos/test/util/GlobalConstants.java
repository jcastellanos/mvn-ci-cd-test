package co.jcastellanos.test.util;

public final class GlobalConstants {
    
    /**
     * Esta clase no puede ser instanciada.
     */
    private GlobalConstants() {
        
    }
    /**
     * Identificador del perfil en modo produccion.
     */
    public static final String PROFILE_PROD = "prod";
    /**
     * Identificador del perfil en modo desarrollo.
     */
    public static final String PROFILE_DEV = "dev";
    /**
     * Cabecera de QOS para perfil de produccion.
     */
    public static final String HEADER_QOS_PROD = "qos";
    /**
     * Cabecera de QOS para perfil de desarrollo.
     */
    public static final String HEADER_QOS_DEV = "authorization";
    /**
     * Nombre de la llave para la autenticacion bearer.
     */
    public static final String BEARER_KEY = "Bearer";
    /**
     * Mensaje de error por defecto para las excepciones.
     */
    public static final String EXCEPTION_MESSAGE = "Se ha presentado un error interno. "
            + "Por favor intente mas tarde. Si el error persiste, por favor informe del error "
            + "utilizando el valor de errorCode";
}
