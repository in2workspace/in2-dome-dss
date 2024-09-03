package es.in2.dss.api.model;

import es.in2.dss.z.model.SignatureType;
import es.in2.dss.z.model.SignedData;
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
