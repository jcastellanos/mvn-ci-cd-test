package co.jcastellanos.test.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ping")
@RestController
public class PingApiController {
    @GetMapping
    public ResponseEntity<?> ping() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
