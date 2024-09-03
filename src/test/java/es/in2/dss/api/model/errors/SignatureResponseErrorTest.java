package es.in2.dss.api.model.errors;

import es.in2.dss.z.model.SignatureResponseError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureResponseErrorTest {

    @Test
    void testGetterAndSetter() {
        // Create a SignatureResponseError object
        SignatureResponseError error = SignatureResponseError.builder()
                .error("signature_type_not_available")
                .description("The signature type 'dummy' is not available")
                .build();
        assertEquals("signature_type_not_available", error.error());
        assertEquals("The signature type 'dummy' is not available", error.description());
    }

}
