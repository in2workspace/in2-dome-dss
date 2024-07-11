package es.in2.remotesignature.api.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignedDataTest {

    @Test
    void testGetterAndSetter() {
        // Create a SignedData object
        SignedData signedData = SignedData.builder()
                .type(SignatureType.JADES)
                .data("Some data")
                .build();
        assertEquals(SignatureType.JADES, signedData.type());
        assertEquals("Some data", signedData.data());
    }

}
