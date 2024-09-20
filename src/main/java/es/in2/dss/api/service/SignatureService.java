package es.in2.dss.api.service;

import es.in2.dss.api.model.SignatureRequest;
import es.in2.dss.api.model.SignedData;
import es.in2.dss.api.model.SignatureType;

public interface SignatureService {
    SignedData sign(SignatureRequest signatureRequest);
    SignatureType getSignatureType();
}
