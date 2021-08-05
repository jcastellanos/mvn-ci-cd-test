package co.jcastellanos.test.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import co.jcastellanos.test.message.ErrorResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseEntityExceptionHandlerTest {

    @Test
    @DisplayName("Excepcion general con mensaje sin log de excepcion para modo produccion")
    public void generalException1() {
        RestResponseEntityExceptionHandler response = new RestResponseEntityExceptionHandler();
        response.showExceptions = false;
        Exception ex = new Exception("Excepcion general.");
        ResponseEntity<ErrorResponse> res = response.generalException(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, res.getStatusCode());
        assertNotNull(res.getBody().getErrorcode());
        assertTrue(!res.getBody().getErrorcode().isEmpty());
        // El mensaje de error debe ser diferente al de la excepcion
        assertNotEquals(ex.getMessage(), res.getBody().getMessage());
    }
    
    @Test
    @DisplayName("Excepcion general con mensaje con log de excepcion para modo desarrollo")
    public void generalException2() {
        RestResponseEntityExceptionHandler response = new RestResponseEntityExceptionHandler();
        response.showExceptions = true;
        Exception ex = new Exception("Excepcion general.");
        ResponseEntity<ErrorResponse> res = response.generalException(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, res.getStatusCode());
        assertNotNull(res.getBody().getErrorcode());
        assertTrue(!res.getBody().getErrorcode().isEmpty());
        // El mensaje de error debe ser igual al de la excepcion
        assertEquals(ex.getMessage(), res.getBody().getMessage());
    }
}
