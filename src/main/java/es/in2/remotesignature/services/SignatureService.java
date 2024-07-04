package es.in2.remotesignature.services;

import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;

public interface SignatureService {
    SignedData sign(SignatureRequest signatureRequest);
    SignatureType getSignatureType();
}
