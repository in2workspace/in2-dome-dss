package es.in2.remotesignature.dtos.errors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureResponseErrorTest {

    @Test
    void testGetterAndSetter() {
        // Create a SignatureResponseError object
        SignatureResponseError error = new SignatureResponseError();

        error.setError("signature_type_not_available");
        error.setDescription("The signature type 'dummy' is not available");

        assertEquals("signature_type_not_available", error.getError());
        assertEquals("The signature type 'dummy' is not available", error.getDescription());
    }

}
