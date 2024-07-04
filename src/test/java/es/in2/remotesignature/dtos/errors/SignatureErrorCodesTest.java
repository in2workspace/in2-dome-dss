package es.in2.remotesignature.dtos.errors;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SignatureErrorCodesTest {
    @Test
    void testConstructor() {
        Constructor<SignatureErrorCodes> constructor;
        try {
            constructor = SignatureErrorCodes.class.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail("Constructor not found");
            return;
        }

        constructor.setAccessible(true);

        try {
            constructor.newInstance();
            fail("Expected exception not thrown");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            assertTrue(e.getCause() instanceof IllegalStateException);
            assertEquals("Utility class", e.getCause().getMessage());
        }
    }
}
