package es.in2.remotesignature.api.service;

import es.in2.remotesignature.api.model.SignatureRequest;
import es.in2.remotesignature.api.model.SignedData;
import es.in2.remotesignature.api.model.SignatureType;

public interface SignatureService {
    SignedData sign(SignatureRequest signatureRequest);
    SignatureType getSignatureType();
}
