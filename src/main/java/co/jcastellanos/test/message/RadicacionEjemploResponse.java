package co.jcastellanos.test.message;

import lombok.Data;

@Data
public class RadicacionEjemploResponse {
    /**
     * Mensaje de respuesta.
     */
    private String mensaje;
    /**
     * Usuario que realiza la peticion.
     */
    private String usuario;
    /**
     * Roles del usuario.
     */
    private String roles;
}
