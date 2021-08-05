package co.jcastellanos.test.message;

import lombok.Data;

@Data
public class ErrorResponse {
    /**
     * Codigo de error.
     */
    private String errorcode;
    /**
     * Timestamp del error.
     */
    private String timestamp;
    /**
     * Mensaje de error.
     */
    private String message;
}
