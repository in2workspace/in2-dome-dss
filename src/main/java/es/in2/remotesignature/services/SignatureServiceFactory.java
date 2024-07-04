package es.in2.remotesignature.services;

import es.in2.remotesignature.enums.SignatureType;

public interface SignatureServiceFactory {
    SignatureService createService(SignatureType type);
}
