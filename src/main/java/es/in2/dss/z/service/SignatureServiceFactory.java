package es.in2.dss.z.service;

import es.in2.dss.z.model.SignatureType;

public interface SignatureServiceFactory {
    SignatureService createService(SignatureType type);
}
