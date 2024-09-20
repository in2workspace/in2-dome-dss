package es.in2.dss.api.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureTypeNotSupportedExceptionTest {
    @Test
    void testConstructorWithSignatureType() {
        String signatureType = "RSA";

        SignatureTypeNotSupportedException exception = new SignatureTypeNotSupportedException(signatureType);

        assertEquals("Signature type: " + signatureType + " is currently not supported", exception.getMessage());
    }
}
