package co.jcastellanos.test.service.impl;

import java.util.Optional;
import co.jcastellanos.test.exception.GeneralRuntimeException;
import co.jcastellanos.test.message.RadicacionEjemploResponse;
import co.jcastellanos.test.service.RadicacionService;
import co.jcastellanos.test.util.LogTrace;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RadicacionServiceImpl implements RadicacionService {

    /**
     * Mensaje de error para forzar camino. Eliminar.
     */
    private static final String ID_ERROR = "error";
    /**
     * Mensaje de excepcion para forzar camino. Eliminar.
     */
    private static final String ID_EXCEPTION = "exception";
    
    /**
     * @inheritDoc
     * @author Juan Carlos Castellanos <jccastellanos@grupoasd.com.co>
     */
    @Override
    public Optional<RadicacionEjemploResponse> ejemplo(String id) {
        LogTrace.trace(log);
        if (id.equalsIgnoreCase(ID_ERROR)) {
            return Optional.empty();
        } else if (id.equalsIgnoreCase(ID_EXCEPTION)) {
            throw new GeneralRuntimeException("Exception forzada.");
        } else {
            RadicacionEjemploResponse res = new RadicacionEjemploResponse();
            res.setMensaje("Hola mundo de ejemplo.");
            return Optional.of(res);
        }
    }

}
