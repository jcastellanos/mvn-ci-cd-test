package co.jcastellanos.test.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import co.jcastellanos.test.message.RadicacionEjemploResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RadicacionServiceImplTest {
    
    @InjectMocks
    RadicacionServiceImpl radicacionService;
    
    @Test
    @DisplayName("Operacion de ejemplo con id valido.")
    public void ejemplo1() {
        String mensajeRespuesta = "Hola mundo de ejemplo.";
        Optional<RadicacionEjemploResponse>  res= radicacionService.ejemplo("123456");
        assertTrue(res.isPresent());
        assertEquals(mensajeRespuesta, res.get().getMensaje());
    }
    
    @Test
    @DisplayName("Operacion de ejemplo con id no valido.")
    public void ejemplo2() {
        Optional<RadicacionEjemploResponse>  res= radicacionService.ejemplo("error");
        assertTrue(res.isEmpty());
    }
    
    @Test
    @DisplayName("Operacion de ejemplo con excepcion.")
    public void ejemplo3() {
        String mensajeError = "Exception forzada.";
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> radicacionService.ejemplo("exception"));
        assertEquals(mensajeError, exception.getMessage());
    }

}
