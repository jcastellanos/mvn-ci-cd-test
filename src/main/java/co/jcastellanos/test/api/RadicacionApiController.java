package co.jcastellanos.test.api;

import co.jcastellanos.test.message.RadicacionEjemploResponse;
import co.jcastellanos.test.service.RadicacionService;
import co.jcastellanos.test.util.LogTrace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;

@Api(value = "radicaciones", description = "API para radicacion de documentos.", tags = { "radicaciones" })
@RequestMapping("${app.context-api}/radicaciones")
@RestController
@Slf4j
public class RadicacionApiController {
    
    /**
     * RadicacionService.
     */
    private final RadicacionService radicacionService;
    
    /**
     * Constructor.
     * @param radicacionService RadicacionService.
     */
    public RadicacionApiController(RadicacionService radicacionService) {
        this.radicacionService = radicacionService;
    }

    /**
     * Operacion de ejemplo. Por favor eliminar.
     * @author Juan Carlos Castellanos <jccastellanos@grupoasd.com.co>
     * @param id Identificador.
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "Operacion de ejemplo.", 
            nickname = "ejemplo",
            notes = "Operacion de ejemplo que debe ser eliminada.",
                    tags = { "radicaciones" })
    @ApiResponses(value = {
        @ApiResponse(
                code = 200, message = "Cadena de ejemplo hola mundo.", 
                response = RadicacionEjemploResponse.class),
        @ApiResponse(
                code = 400, message = "Identificador no valido.")
        }
    )
    @GetMapping
    public ResponseEntity<?> ejemplo(@ApiParam(required = true, value = "Identificador de ejemplo") 
        @RequestParam String id) {
        LogTrace.trace(log);
        return radicacionService.ejemplo(id)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
