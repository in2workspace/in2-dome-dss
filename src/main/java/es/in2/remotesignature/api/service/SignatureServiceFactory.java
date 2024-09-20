package es.in2.remotesignature.api.service;

import es.in2.remotesignature.api.model.SignatureType;

public interface SignatureServiceFactory {
    SignatureService createService(SignatureType type);
}
