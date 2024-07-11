package es.in2.remotesignature.api.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LoadKeyStoreExceptionTest {

    @Test
    void testConstructorWithException() {
        Exception mockException = mock(Exception.class);

        LoadKeyStoreException exception = new LoadKeyStoreException(mockException);

        assertEquals("Error loading keystore", exception.getMessage());
        assertEquals(mockException, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndException() {
        Exception mockException = mock(Exception.class);

        LoadKeyStoreException exception = new LoadKeyStoreException("Custom message", mockException);

        assertEquals("Custom message", exception.getMessage());
        assertEquals(mockException, exception.getCause());
    }
}