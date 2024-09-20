package es.in2.dss.api.service;

import es.in2.dss.api.model.SignatureType;

public interface SignatureServiceFactory {
    SignatureService createService(SignatureType type);
}
