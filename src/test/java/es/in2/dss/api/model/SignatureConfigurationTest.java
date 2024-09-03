package es.in2.dss.api.model;

import es.in2.dss.z.model.SignatureConfiguration;
import es.in2.dss.z.model.SignatureType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureConfigurationTest {

    @Test
    void testGetterAndSetter() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("key1", "value1");
        parameters.put("key2", "value2");

        SignatureConfiguration signatureConfig = SignatureConfiguration.builder()
                .type(SignatureType.JADES)
                .parameters(parameters)
                .build();

        assertEquals(SignatureType.JADES, signatureConfig.type());
        assertEquals(parameters, signatureConfig.parameters());
    }

}
