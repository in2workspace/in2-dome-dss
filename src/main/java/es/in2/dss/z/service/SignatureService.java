package es.in2.dss.z.service;

import es.in2.dss.z.model.SignatureRequest;
import es.in2.dss.z.model.SignedData;
import es.in2.dss.z.model.SignatureType;

public interface SignatureService {
    SignedData sign(SignatureRequest signatureRequest);
    SignatureType getSignatureType();
}
