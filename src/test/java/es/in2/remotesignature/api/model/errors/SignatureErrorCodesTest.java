package es.in2.remotesignature.api.model.errors;

import es.in2.remotesignature.api.util.SignatureErrorCodes;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

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
            assertInstanceOf(IllegalStateException.class, e.getCause());
            assertEquals("Utility class", e.getCause().getMessage());
        }
    }

}
