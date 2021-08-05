package co.jcastellanos.test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;

import co.jcastellanos.test.message.RadicacionEjemploResponse;
import co.jcastellanos.test.service.impl.RadicacionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class RadicacionApiControllerTest {

    @InjectMocks
    RadicacionApiController RadicacionApiController;
    
    @Mock
    RadicacionServiceImpl radicacionService;
    
    @Test
    @DisplayName("Operacion de ejemplo con id valido.")
    public void ejemplo1() {
        String id = "123456";
        String mensajeRes = "Mensaje";
        RadicacionEjemploResponse mockRes = new RadicacionEjemploResponse();
        mockRes.setMensaje("Mensaje");
        when(radicacionService.ejemplo(id)).thenReturn(Optional.of(mockRes));
        ResponseEntity<?> res = RadicacionApiController.ejemplo(id);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        RadicacionEjemploResponse objRes = (RadicacionEjemploResponse) res.getBody();
        assertEquals(mensajeRes, objRes.getMensaje()); 
    }
    
    @Test
    @DisplayName("Operacion de ejemplo con id no valido.")
    public void ejemplo2() {
        String id = "error";
        when(radicacionService.ejemplo(id)).thenReturn(Optional.empty());
        ResponseEntity<?> res = RadicacionApiController.ejemplo(id);
        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode()); 
    }
}
