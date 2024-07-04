package es.in2.remotesignature.dtos;

import es.in2.remotesignature.enums.SignatureType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureConfigurationTest {

    @Test
    void testGetterAndSetter() {
        SignatureConfiguration signatureConfig = new SignatureConfiguration();

        signatureConfig.setType(SignatureType.JADES);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("key1", "value1");
        parameters.put("key2", "value2");
        signatureConfig.setParameters(parameters);

        assertEquals(SignatureType.JADES, signatureConfig.getType());
        assertEquals(parameters, signatureConfig.getParameters());
    }

}
