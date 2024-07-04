package es.in2.remotesignature.dtos;

import es.in2.remotesignature.enums.SignatureType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignedDataTest {

    @Test
    void testGetterAndSetter() {
        // Create a SignedData object
        SignedData signedData = new SignedData();

        signedData.setType(SignatureType.JADES);
        signedData.setData("Some data");

        assertEquals(SignatureType.JADES, signedData.getType());
        assertEquals("Some data", signedData.getData());
    }


}
