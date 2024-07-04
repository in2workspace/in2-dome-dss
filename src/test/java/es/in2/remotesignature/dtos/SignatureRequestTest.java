package es.in2.remotesignature.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureRequestTest {

    @Test
    void testGetterAndSetter() {
        // Create a SignatureRequest object
        SignatureRequest signatureRequest = new SignatureRequest();

        SignatureConfiguration configuration =  new SignatureConfiguration();
        signatureRequest.setConfiguration(configuration);
        signatureRequest.setData("{\"username\":\"alfresco123\", \"age\": 25}");

        assertEquals(configuration, signatureRequest.getConfiguration());
        assertEquals("{\"username\":\"alfresco123\", \"age\": 25}", signatureRequest.getData());
    }

}