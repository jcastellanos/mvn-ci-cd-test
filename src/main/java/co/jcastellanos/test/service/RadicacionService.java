package co.jcastellanos.test.service;

import co.jcastellanos.test.message.RadicacionEjemploResponse;

import java.util.Optional;

public interface RadicacionService {

    Optional<RadicacionEjemploResponse> ejemplo(String id);
}
